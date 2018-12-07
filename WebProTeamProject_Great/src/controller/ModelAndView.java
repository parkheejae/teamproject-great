
package controller;
/*
 * ����������� ���� �̸���
 * � ����̷� �̵������� ���� ������ ��� �ִ� ��ü
 * ���߿��� ������ �̸��� API�� ����ϰ� �� ���Դϴ�.
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









