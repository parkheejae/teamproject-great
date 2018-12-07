
package controller;
/*
 * 결과페이지에 대한 이름과
 * 어떤 방식이로 이동할지에 대한 정보를 담고 있는 객체
 * 나중에는 동일한 이름의 API를 사용하게 될 것입니다.
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect; //false
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView() {	}
	
	public ModelAndView(String path) {		
		this.path = path;		
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}	
	
}









