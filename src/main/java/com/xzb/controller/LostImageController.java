package com.xzb.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.xzb.pojo.Lost;
import com.xzb.pojo.LostImage;
import com.xzb.service.LostImageService;
import com.xzb.service.LostService;
import com.xzb.util.ImageUtil;
import com.xzb.util.UploadedImageFile;

//图片管理controller层
@Controller
@RequestMapping("")
public class LostImageController {
    @Autowired
    LostService lostService;
 
    @Autowired
    LostImageService lostImageService;
 

    
    @RequestMapping("admin_lostImage_add")
	public String add(LostImage li, HttpSession session, UploadedImageFile uploadedImageFile) {
		System.out.println(li.getId());
		//将产品图片插入到数据库中，id自增
		lostImageService.add(li);
		System.out.println(li.getId());
		String fileName = li.getId() + ".jpg";
		String imageFolder;
		String imageFolder_small = null;
		String imageFolder_middle = null;
		//图片类型为单个图片时，保存为大中小三种格式，这里新建三个文件夹
		if (LostImageService.type_single.equals(li.getType())) {
			imageFolder = session.getServletContext().getRealPath("img/lostSingle");
			imageFolder_small = session.getServletContext().getRealPath("img/lostSingle_small");
			imageFolder_middle = session.getServletContext().getRealPath("img/lostSingle_middle");
		} else {
			//类型为详情图片时只建一个文件夹
			imageFolder = session.getServletContext().getRealPath("img/lostDetail");
		}

		File f = new File(imageFolder, fileName);
		System.out.println(imageFolder);
		f.getParentFile().mkdirs();
		System.out.println(f+"");
		try {
			uploadedImageFile.getImage().transferTo(f);
			BufferedImage img = ImageUtil.change2jpg(f);
			ImageIO.write(img, "jpg", f);

			if (LostImageService.type_single.equals(li.getType())) {
				//再存一张小型的和中型的图片
				File f_small = new File(imageFolder_small, fileName);
				File f_middle = new File(imageFolder_middle, fileName);

				ImageUtil.resizeImage(f, 56, 56, f_small);
				ImageUtil.resizeImage(f, 217, 190, f_middle);
				System.out.println("成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("文件路径"+session.getServletContext().getContextPath());
		return "redirect:admin_lostImage_list?lid=" + li.getLid();
	}
 
    //删除图片
    @RequestMapping("admin_lostImage_delete")
    public String delete(int id,HttpSession session) {
        LostImage li = lostImageService.get(id);
 
        String fileName = li.getId()+ ".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;
 
        //三个文件夹中大中小三个图片都要删除
        if(LostImageService.type_single.equals(li.getType())){
            imageFolder= session.getServletContext().getRealPath("img/lostSingle");
            imageFolder_small= session.getServletContext().getRealPath("img/lostSingle_small");
            imageFolder_middle= session.getServletContext().getRealPath("img/lostSingle_middle");
            File imageFile = new File(imageFolder,fileName);
            File f_small = new File(imageFolder_small,fileName);
            File f_middle = new File(imageFolder_middle,fileName);
            imageFile.delete();
            f_small.delete();
            f_middle.delete();
 
        }
        else{
            imageFolder= session.getServletContext().getRealPath("img/lostDetail");
            File imageFile = new File(imageFolder,fileName);
            imageFile.delete();
        }
 
        lostImageService.delete(id);
 
        return "redirect:admin_lostImage_list?lid=" + li.getLid();
    }
 
    //查询图片列表
    @RequestMapping("admin_lostImage_list")
    public String list(int lid, Model model) {
    	System.out.println("admin_lostImage_list"+lid);
        Lost l =lostService.get(lid);
        List<LostImage> lisSingle = lostImageService.list(lid, lostImageService.type_single);
        List<LostImage> lisDetail = lostImageService.list(lid, lostImageService.type_detail);
 
        model.addAttribute("l", l);
        model.addAttribute("lisSingle", lisSingle);
        model.addAttribute("lisDetail", lisDetail);
 
        return "admin/listLostImage";
    }
}