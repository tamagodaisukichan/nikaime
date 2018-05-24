package bean;

import java.io.Serializable;
import java.util.Date;

public class SerchBean implements Serializable{
	private int kaiinId;
	private String kaiinName;
	private Date tourokubi;
	public int getKaiinId() {
		return kaiinId;
	}
	public void setKaiinId(int kaiinId) {
		this.kaiinId = kaiinId;
	}
	public String getKaiinName() {
		return kaiinName;
	}
	public void setKaiinName(String kaiinName) {
		this.kaiinName = kaiinName;
	}
	public Date getTourokubi() {
		return tourokubi;
	}
	public void setTourokubi(Date tourokubi) {
		this.tourokubi = tourokubi;
	}

}
