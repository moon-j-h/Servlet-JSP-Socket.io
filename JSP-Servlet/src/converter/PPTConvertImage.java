package converter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
 


import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

 
/**
 * PPT파일을 이미지로 변환
 * @author falbb
 *
 */
public class PPTConvertImage {
	private FileInputStream is;
	private String memberId;
	private String pptFileName;
	private String imageType;
	private String firstDirPath;
	private String secondDirPath;
 
	public PPTConvertImage() {
		this.is = null;
		this.memberId = "";
		this.pptFileName = "";
		this.imageType = "";
		this.firstDirPath = "C:\\temp\\" + memberId;
		this.secondDirPath = firstDirPath + "\\" + pptFileName;
	}

	public PPTConvertImage(FileInputStream is, String memberId, String pptFileName, String imageType, String firstDirPath, String secondDirPath) {
		this.is = is;
		this.memberId = memberId;
		this.pptFileName = pptFileName;
		this.imageType = imageType;
		this.firstDirPath = firstDirPath;
		this.secondDirPath = secondDirPath;
	}
	
	public PPTConvertImage(FileInputStream is, String memberId, String pptFileName, String imageType, String firstDirPath) {
		this.is = is;
		this.memberId = memberId;
		this.pptFileName = pptFileName;
		this.imageType = imageType;
		this.firstDirPath = firstDirPath + "\\" + memberId;
		this.secondDirPath = this.firstDirPath + "\\" + pptFileName;
	}
	
	public PPTConvertImage(FileInputStream is, String memberId, String pptFileName, String imageType) {
		this.is = is;
		this.memberId = memberId;
		this.pptFileName = pptFileName;
		this.imageType = imageType;
		this.firstDirPath = "C:\\temp\\" + memberId;
		this.secondDirPath = firstDirPath + "\\" + pptFileName;
	}
	
	public PPTConvertImage(FileInputStream is, String memberId, String pptFileName) {
		this.is = is;
		this.memberId = memberId;
		this.pptFileName = pptFileName;
		this.imageType = "png";
		this.firstDirPath = "C:\\temp\\" + memberId;
		this.secondDirPath = firstDirPath + "\\" + pptFileName;
	}

	public FileInputStream getIs() {
		return is;
	}

	public void setIs(FileInputStream is) {
		this.is = is;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPptFileName() {
		return pptFileName;
	}

	public void setPptFileName(String pptFileName) {
		this.pptFileName = pptFileName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getFirstDirPath() {
		return firstDirPath;
	}

	public void setFirstDirPath(String firstDirPath) {
		this.firstDirPath = firstDirPath;
	}

	public String getSecondDirPath() {
		return secondDirPath;
	}

	public void setSecondDirPath(String secondDirPath) {
		this.secondDirPath = secondDirPath;
	}

	/**
	 * 이미지 변환 실행
	 * @throws IOException
	 */
	public void pptConvter(int cvtMax) throws IOException {
		SlideShow ppt = new SlideShow(this.is);
 
		// PPT파일 닫기
		this.is.close();
 
		Dimension pgsize = ppt.getPageSize();
 
		Slide[] slide = ppt.getSlides();
		
		if( cvtMax != 1 ){
			cvtMax = slide.length;
		}
		
		for (int i = 0; i < cvtMax; i++) {
			
			BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
			//(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);//TYPE_3BYTE_BGR);
			
			Graphics2D graphics = img.createGraphics();
			
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
	                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			
			// 이미지 영역을 클리어
			graphics.setPaint(Color.white);
			graphics.clearRect(0, 0, pgsize.width, pgsize.height);
			graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,
					pgsize.height));
 
			// 이미지 그리기
			slide[i].draw(graphics);
			
			// 파일로 저장
			FileOutputStream out = new FileOutputStream(this.secondDirPath + "\\" + (i + 1) + "."+ this.imageType);
			ImageIO.write(img, this.imageType, out);
			out.close();
		}
	}
	
	/**
	 * 이미지 변환 실행
	 * @throws IOException
	 */
	public void pptxConvter(int cvtMax) throws IOException {
		XMLSlideShow pptx = new XMLSlideShow(this.is);
 
		// PPT파일 닫기
		this.is.close();
 
		Dimension pgsize = pptx.getPageSize();
 
		XSLFSlide[] slide = pptx.getSlides();
		
		if( cvtMax != 1 ){
			cvtMax = slide.length;
		}
		
		for (int i = 0; i < cvtMax; i++) {
			
			BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
			//(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);//TYPE_3BYTE_BGR);
			
			Graphics2D graphics = img.createGraphics();
			
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
	                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			
			// 이미지 영역을 클리어
			graphics.setPaint(Color.white);
			graphics.clearRect(0, 0, pgsize.width, pgsize.height);
			graphics.fill(new Rectangle2D.Double(0, 0, pgsize.width, pgsize.height));
 
			// 이미지 그리기
			slide[i].draw(graphics);
			
			// 파일로 저장
			FileOutputStream out = new FileOutputStream(this.secondDirPath + "\\" + (i + 1) + "." + this.imageType);
			ImageIO.write(img, this.imageType, out);
			out.close();
		}
	}
	
	public void createMemberDirectory() {
		File theDir = new File(this.firstDirPath);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			//System.out.println("creating directory: " + this.firstDirPath);
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
				System.out.println("Security Exception at directory creation");
			}
			if (result) {
				System.out.println("DIR created");
			}
		}
	}
	
	public void createPptFileDirectory() {
		File theDir = new File(this.secondDirPath);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			//System.out.println("creating directory: " + this.secondDirPath);
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
				System.out.println("Security Exception at directory creation");
			}
			if (result) {
				System.out.println("DIR created");
			}
		}
	}
	
	public int checkMaxPageNum(String path, String memberId, String fileName){
		int i=1;
		
		while (true) {
			try {
				ImageIO.read(new File(path+"\\"+memberId+"\\"+fileName+"\\"+i+".jpg"));
				i++;
			} catch (IOException e) {
				break;
			}
		}
		
		return i-1;
	}
}