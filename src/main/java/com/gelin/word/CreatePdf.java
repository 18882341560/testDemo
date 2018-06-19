package com.gelin.word;

import java.io.*;
import java.util.List;

import org.docx4j.Docx4J;
import org.docx4j.convert.out.pdf.viaXSLFO.PdfSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * Created by 葛林 on 2018/1/5.
 */
public class CreatePdf {

//    public static void main(String[] args) {
//        try {
//
//            long start = System.currentTimeMillis();
//
//            InputStream is = new FileInputStream(
//                    new File("C:\\Users\\Administrator\\Desktop\\本公司系统\\接口文档.docx"));
//            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
//                    .load(is);
//            List sections = wordMLPackage.getDocumentModel().getSections();
//            for (int i = 0; i < sections.size(); i++) {
//
//                System.out.println("sections Size" + sections.size());
//                wordMLPackage.getDocumentModel().getSections().get(i)
//                        .getPageDimensions().setHeaderExtent(3000);
//            }
//            Mapper fontMapper = new IdentityPlusMapper();
//
//            PhysicalFont font = PhysicalFonts.getPhysicalFonts().get(
//                    "Comic Sans MS");
//
//            fontMapper.getFontMappings().put("Algerian", font);
//
//            wordMLPackage.setFontMapper(fontMapper);
//            PdfSettings pdfSettings = new PdfSettings();
//            org.docx4j.convert.out.pdf.PdfConversion conversion = new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(
//                    wordMLPackage);
//
//            OutputStream out = new FileOutputStream(new File(
//                    "D:\\1.pdf"));
//            conversion.output(out, pdfSettings);
//            System.err.println("Time taken to Generate pdf  "
//                    + (System.currentTimeMillis() - start) + "ms");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        String inputWordPath = "D:\\1.docx";
        String outputPDFPath = "D:\\1.pdf";
        try {
            System.err.println("Word Document to PDF Convert Begins!");
            InputStream is = new FileInputStream(new File(inputWordPath));
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(is);
            List sections = wordMLPackage.getDocumentModel().getSections();
            for (int i = 0; i < sections.size(); i++) {
                wordMLPackage.getDocumentModel().getSections().get(i).getPageDimensions().setHeaderExtent(3000);
            }
            Mapper fontMapper = new IdentityPlusMapper();
//            PhysicalFont font = PhysicalFonts.getPhysicalFonts().get(
//                    "宋体");
//            fontMapper.getFontMappings().put("宋体", font);
            fontMapper.getFontMappings().put("隶书", PhysicalFonts.getPhysicalFonts().get("LiSu"));
            fontMapper.getFontMappings().put("宋体", PhysicalFonts.getPhysicalFonts().get("SimSun"));
            fontMapper.getFontMappings().put("微软雅黑", PhysicalFonts.getPhysicalFonts().get("Microsoft Yahei"));
            fontMapper.getFontMappings().put("黑体", PhysicalFonts.getPhysicalFonts().get("SimHei"));
            fontMapper.getFontMappings().put("楷体", PhysicalFonts.getPhysicalFonts().get("KaiTi"));
            fontMapper.getFontMappings().put("新宋体", PhysicalFonts.getPhysicalFonts().get("NSimSun"));
            fontMapper.getFontMappings().put("华文行楷", PhysicalFonts.getPhysicalFonts().get("STXingkai"));
            fontMapper.getFontMappings().put("华文仿宋", PhysicalFonts.getPhysicalFonts().get("STFangsong"));
            fontMapper.getFontMappings().put("宋体扩展", PhysicalFonts.getPhysicalFonts().get("simsun-extB"));
            fontMapper.getFontMappings().put("仿宋", PhysicalFonts.getPhysicalFonts().get("FangSong"));
            fontMapper.getFontMappings().put("仿宋_GB2312", PhysicalFonts.getPhysicalFonts().get("FangSong_GB2312"));
            fontMapper.getFontMappings().put("幼圆", PhysicalFonts.getPhysicalFonts().get("YouYuan"));
            fontMapper.getFontMappings().put("华文宋体", PhysicalFonts.getPhysicalFonts().get("STSong"));
            fontMapper.getFontMappings().put("华文中宋", PhysicalFonts.getPhysicalFonts().get("STZhongsong"));
            wordMLPackage.setFontMapper(fontMapper);
            Docx4J.toPDF(wordMLPackage, new FileOutputStream(outputPDFPath));
            System.err.println("Your Word Document Converted to PDF Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
