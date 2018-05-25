package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Fri May 25 10:30:47 JST 2018
 */
import java.io.Serializable;
import java.util.Date;

/**
 * KaiinVo.
 * @author yuka.tokoro
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/05/25	yuka.tokoro		Generated.
 */
public class KaiinVo implements Serializable {

	public static final String TABLE = "KAIIN";

	/**
	 * kaiinNo:int(10) <Primary Key>
	 */
	private int kaiinno;

	/**
	 * name:varchar(200)
	 */
	private String name;

	/**
	 * registDate:date(0)
	 */
	private Date registdate;

	/**
	 * sex:varchar(3)
	 */
	private String sex;

	/**
	* Constractor
	*/
	public KaiinVo() {
		this.registdate = new Date(); //登録日時
	}

	/**
	* Constractor
	* @param <code>kaiinno</code>
	*/
	public KaiinVo(int kaiinno) {
		this.kaiinno = kaiinno;
	}

	public int getKaiinno() {
		return this.kaiinno;
	}

	public void setKaiinno(int kaiinno) {
		this.kaiinno = kaiinno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistdate() {
		return this.registdate;
	}

	public void setRegistdate(java.sql.Date registdate) {
		this.registdate = registdate;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[KaiinVo:");
		buffer.append(" kaiinno: ");
		buffer.append(kaiinno);
		buffer.append(" name: ");
		buffer.append(name);
		buffer.append(" registdate: ");
		buffer.append(registdate);
		buffer.append(" sex: ");
		buffer.append(sex);
		buffer.append("]");
		return buffer.toString();
	}

}
