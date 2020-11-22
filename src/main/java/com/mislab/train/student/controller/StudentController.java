package com.mislab.train.student.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import com.mislab.train.student.pojo.StuInfo;
import com.mislab.train.student.pojo.Student;
import com.mislab.train.student.pojo.Swork;
import com.mislab.train.student.service.FileManagerService;
import com.mislab.train.student.service.StudentService;
import com.mislab.train.student.service.SworkService;
import com.mislab.train.student.utils.MultiFileInfo;
import com.mislab.train.student.utils.MultiFileUploadUtils;
import com.mislab.train.teacher.common.Result;
import com.mislab.train.teacher.entity.Aspiration;
import com.mislab.train.teacher.entity.Work;
import com.mislab.train.teacher.service.AspirService;
import com.mislab.train.teacher.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author xhx
 * @Date 2020/11/3 17:31
 */
@RestController
@RequestMapping("/stu")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    SworkService sworkService;
    @Autowired
    WorkService workService;
    @Autowired
    AspirService aspirService;
    @Autowired
    private FileManagerService fileManagerService;

    private int sworkId;
    @Value("filePath.saveFileBasePath")
    private String savedPath;

    /**
     * 文件上传
     *
     * @param
     * @param file 附件字节码文件
     * @return 返回处理结果，请求头200:成功,500:失败
     * @throws Exception
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public void MutiluploadFile(@RequestParam("name") String name,
                                @RequestParam("size") Long size,
                                @RequestParam("chunk") Integer chunk,
                                @RequestParam("chunks") Integer chunks,
                                @RequestParam("allSize") Long allSize,
                                @RequestParam(required = false, value = "file") MultipartFile file, HttpServletResponse response) throws Exception {
        MultiFileInfo fileinfo = new MultiFileInfo(name, size, chunk, chunks, allSize);
        try {
            log.info("第"+chunk+"个分片的大小为："+file.getSize());
            if (file != null && !file.isEmpty()) {
                //切片上传
                if (MultiFileUploadUtils.checkMultiFilePremeter(fileinfo)) {
                    fileManagerService.saveMultiBurstFiletoDir(fileinfo, file);
                    //单文件整体上传
                } else if (MultiFileUploadUtils.checkSingFilePremeter(fileinfo)) {
                    fileManagerService.saveSingleFiletoDir(fileinfo, file);
                    log.info(fileinfo.toString());
                } else {
                    log.info("文件上传参数不合法");
                    ErrorPremetersException e = new ErrorPremetersException("文件上传参数不合法");
                    throw e;
                }
            } else {
                ErrorPremetersException e = new ErrorPremetersException("文件上传参数不合法");
                log.info("第"+chunk+"分片流为空");
                throw e;
            }
        } catch (Exception | ErrorPremetersException e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }

    /**
     * 文件分片合并
     *
     * @return 返回处理结果，请求头200:成功,500:失败
     * @throws Exception
     */
    @RequestMapping(value = "/mergingChunks", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> MutilMergingChunksForFile(@RequestParam("fileName") String fileName,
                                                                         @RequestParam("stuId") String stuId,
                                                                         @RequestParam("wordId") Integer workId,
                                                                         @RequestParam("aspirId") Integer aspirId
    ) throws Exception {
        try {
            fileManagerService.MultiMergingChunks(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Result.fail(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String src ="123.57.31.120/api/swork/saved/" + fileName;
        Swork swork = new Swork(sworkId, stuId, workId, aspirId, src, initDate(),0);
        sworkService.addSwork(swork);
        return new ResponseEntity<>(Result.success(swork,"添加成功！"), HttpStatus.OK);
    }

    /**
     * 学员注册
     *
     * @param student
     * @return
     */
    @RequestMapping("/reg")
    public Map addStudent(@RequestBody Student student) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;
        try {
            result = studentService.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("注册失败");
        }
        if (result == 1) {
            map = Result.success();
            return map;
        }
        return map;
    }

    /**
     * 登陆校验密码
     *
     * @param data
     * @param httpSession
     * @return
     */
    @RequestMapping("/login")
    public Map stuLogin(@RequestBody Map<String, Object> data, HttpSession httpSession) {
        Map<String, Object> map;
        StuInfo stuInfo = studentService.loginCheck((String) data.get("stuId"), (String) data.get("pwd"));
        if (stuInfo == null) {
            map = Result.fail("用户名或密码错误");
        } else {
            httpSession.setAttribute("student", stuInfo);
            map = Result.success(stuInfo, "登陆成功！");
        }
        return map;
    }

//    /**
//     * 简单多媒体上传
//     *
//     * @param file
//     * @param data
//     * @return
//     */
//    @RequestMapping("/upload")
//    public Map addSword(MultipartFile file, @RequestBody Map<String, Object> data) {
//        Map<String, Object> map;
//        StringBuffer realPath = new StringBuffer("");
//        String stringPath = realPath.append(file.getOriginalFilename()).toString();
//        Date currentTime = initDate();
//        sworkId = initSworkID();
//        Swork swork = new Swork(sworkId, (String) data.get("stuId"), (Integer) data.get("workId"), (Integer) data.get("aspirId"), stringPath, currentTime);
//        if (sworkService.addSwork(swork) != 0) {
//            map = Result.success(swork, "添加成功");
//            return map;
//        }
//        map = Result.fail("添加失败");
//        return map;
//    }

    /**
     * @param data data传入方向编号信息信息
     * @return
     */
    @RequestMapping("/showwork")
    public Map showAspirWork(@RequestBody Map<String, Integer> data) {
        Map<String, Object> map;
        ;
        List<Work> worksByAspirId = workService.getWorksByAspirId(data.get("aspir"));
        map = Result.success(worksByAspirId, "查询成功！");
        return map;
    }

    /**
     * data 中包含了stuId、workId、aspir信息
     * 学生查看自己的作业
     *
     * @param data
     * @return
     */
    @RequestMapping("/showmywork")
    public Map findSwork(@RequestBody Map<String, Object> data) {
        Map<String, Object> map;
        List<Swork> swork = sworkService.findSwork((String) data.get("stuId"), (Integer) data.get("workId"), (Integer) data.get("aspir"));
        if (swork == null) {
            return Result.success("没有该记录");
        }
        map = Result.success(swork, "查询成功！");
        return map;
    }

    /**
     * 根据sworkId删除本地文件、及记录
     *
     * @param data
     * @return
     */
    @RequestMapping("/delete")
    public Map deleteWork(@RequestBody Map<String, Integer> data) {
        Map<String, Object> map;
        int i = sworkService.deleteSwork(data.get("sworkId"));
        if (i == 0) {
            map = Result.fail("删除失败");
        } else {
            map = Result.success();
        }
        return map;
    }

    /**
     * 展示所有的方向信息
     *
     * @param data
     * @return
     */
    @RequestMapping("/allcourse")
    public Map findCourses(@RequestBody Map<String, Integer> data) {
        List<Aspiration> aspirations = aspirService.queryByTeaId(data.get("teaId"));
        return Result.success(aspirations, "查询成功");
    }
    @GetMapping("/aspirs")
    public Map<String, Object> aspirs() {
        List<Aspiration> aspirations = aspirService.queryAll();
        return Result.success(aspirations);
    }

    /**
     * 初始化注册学员的ID信息
     */
    private Integer initSworkID() {
        Date date = new Date();
        sworkId = (int) date.getTime();
        if (sworkId < 0) {
            sworkId = -sworkId;
        }
        return sworkId;
    }

    /**
     * 初始化时间信息
     * @return
     */
    private Date initDate() {
        return new Date();
    }
}
