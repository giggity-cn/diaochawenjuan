package cn.hs.util;

import com.alibaba.fastjson.serializer.UUIDCodec;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.FactoryConfigurationError;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  通用的专门用来实现上传的工具类
 */
public class UploadUtils {
    /**
     * 上传的工具类方法
     * @param request 请求信息
     * @return 真正的客户请求的key-value的值 包含上传的文件的key-value
     */
    public static Map<String,String> upload(HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        // 1.创建文件项工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2.创建上传组件
        ServletFileUpload  load = new ServletFileUpload(factory);
        // 3.使用上传组件来解析请求对象
        try {
            List<FileItem> fileItems = load.parseRequest(request);
            // 4.遍历文件项集合，分别处理信息
            for(FileItem fi : fileItems){
                // 5.判断是否是普通表单并处理
                if(fi.isFormField()){
                    String key = fi.getFieldName();
                    String value = fi.getString("UTF-8");
                    map.put(key,value);
                }else{
                    // 6.处理需要上传的表单信息
                    String key = fi.getFieldName();
                    String name = fi.getName();
                    // 判断当前的需要上传的文件是否有值，如果没有数据，则不需要实现上传
                    if(name!=null && !"".equals(name)){
                        // 需要上传
                        // 判断是否是全路径，如果是则去除路径，只要文件名
                        if(name.contains("\\")){
                            name = name.substring(name.lastIndexOf("\\")+1);
                        }
                        // 使用uuid来解决文件名重名问题
                        name = UuidUtil.getUuid()+"-"+name;
                        // 上传
                        File file = new File("D:\\file");
                        if(!file.exists() ){
                            file.mkdir();
                        }
                        File newfile = new File("D:\\file\\"+name);
                        fi.write(newfile);
                    }
                    map.put(key,name);
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  map;
    }


}
