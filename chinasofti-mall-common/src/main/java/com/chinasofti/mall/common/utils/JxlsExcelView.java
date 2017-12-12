package com.chinasofti.mall.common.utils;
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.Map;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import net.sf.jxls.transformer.XLSTransformer;  
  
import org.apache.poi.ss.usermodel.Workbook;  
import org.springframework.web.servlet.view.AbstractView;  
  
public class JxlsExcelView extends AbstractView {  
      
    private static final String CONTENT_TYPE = "application/vnd.ms-excel";  
  
    private String templatePath;  
  
    private String exportFileName;  
  
    /** 
     * @param templatePath 模版相对于当前classpath路径 
     * @param exportFileName 导出文件名 
     */  
    public JxlsExcelView(String templatePath, String exportFileName) {  
        this.templatePath = templatePath;  
        this.exportFileName = exportFileName;  
        setContentType(CONTENT_TYPE);  
    }  
  
    @Override  
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
          
		InputStream is = null;
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			response.setContentType(getContentType());

			// 解决导出文件名中文乱码
			String filename = new String(exportFileName.getBytes("gb2312"), "iso8859-1");
			response.setHeader("content-disposition", "attachment;filename=" + filename + ".xls");

			// 获取excel模板
			is = JxlsExcelView.class.getClassLoader().getResourceAsStream(templatePath);

			// 转换成excel并输出
			XLSTransformer transformer = new XLSTransformer();
			Workbook workbook = transformer.transformXLS(is, model);

			// 将内容写入输出流并把缓存的内容全部发出去
			workbook.write(os);
			os.flush();
			os.close();
			is.close();

		} catch (Exception e) {
			throw e;
		} finally {
			if (os != null) {
				os.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}
}  