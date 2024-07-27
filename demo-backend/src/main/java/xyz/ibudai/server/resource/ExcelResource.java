package xyz.ibudai.server.resource;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.common.vo.SysUser;
import xyz.ibudai.server.service.SysUserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/request")
public class ExcelResource {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("demo1")
    public String demo1() {
        return "Hello world!";
    }

    @GetMapping("demo2")
    public void demo2() {
        throw new RuntimeException("Programme error.");
    }

    @GetMapping("downloadFile")
    public void downloadFiles(@RequestParam(value = "Info") String Info,
                              HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setHeader("filename", URLEncoder.encode("test", "UTF-8"));
        response.getOutputStream()
                .write(Info.getBytes(StandardCharsets.UTF_8));
    }

    @GetMapping("downloadExcel")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        // 设置请求头部参数
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("filename", URLEncoder.encode("test.xlsx", "UTF-8"));
        response.setCharacterEncoding("utf-8");

        List<SysUser> userList = sysUserService.queryAll();
        EasyExcel.write(response.getOutputStream())
                .head(SysUser.class)
                .sheet("User data")
                // 宽度自适应
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                // 写入内容
                .doWrite(userList);
    }
}
