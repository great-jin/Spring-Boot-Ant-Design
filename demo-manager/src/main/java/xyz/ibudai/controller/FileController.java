package xyz.ibudai.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.entity.SysUser;
import xyz.ibudai.service.SysUserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("downloadFiles")
    public void downloadFiles(@RequestParam(value = "Info") String Info,
                              HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setHeader("filename", URLEncoder.encode("hello", "UTF-8"));
        response.getOutputStream()
                .write(Info.getBytes(StandardCharsets.UTF_8));
    }

    @GetMapping("downloadExcel")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        // 设置请求头部参数
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("filename", URLEncoder.encode("hello", "UTF-8"));
        response.setCharacterEncoding("utf-8");

        List<SysUser> userList = sysUserService.queryAll();
        List<String> header = new ArrayList<>();
        List<List<String>> collect = header.stream().map(Arrays::asList).collect(Collectors.toList());
        EasyExcel.write(response.getOutputStream())
                .sheet("Info")
                // 宽度自适应
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                // 写入内容
                .doWrite(userList);
    }
}
