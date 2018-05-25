package servise;

import java.sql.Connection;
import java.sql.SQLException;

import bean.RegistBean;
import bean.SerchBean;
import dao.Dao;
import dao.KaiinMgr;
import vo.KaiinVo;

public class KaiinServise {

	KaiinMgr mgr = new KaiinMgr();
//会員検索
	public SerchBean getSerch(int Id) {

		SerchBean sb = new SerchBean();
		try (Connection con = Dao.getConnection();) {

			KaiinVo kv = mgr.searchKaiin(Id, con);

			sb.setKaiinId(kv.getKaiinno());
			sb.setKaiinName(kv.getName());
			sb.setSex(kv.getSex());
			sb.setTourokubi(kv.getRegistdate());

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return sb;

	}
//会員登録
	public RegistBean setKaiin(int id, String name, String sex) {

		RegistBean rb = new RegistBean();
		try (Connection con = Dao.getConnection();) {

			KaiinVo kv = mgr.registKaiin(id, name, sex, con);

			rb.setKaiinId(kv.getKaiinno());
			rb.setKaiinName(kv.getName());
			rb.setSex(kv.getSex());
			rb.setTourokubi(kv.getRegistdate());

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return rb;
	}
}
