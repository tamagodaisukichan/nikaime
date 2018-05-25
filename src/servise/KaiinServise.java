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

	public SerchBean getSerch(int Id) {
		KaiinVo kv = null;
		SerchBean sb = new SerchBean();
		try (Connection con = Dao.getConnection();) {

			kv = mgr.searchKaiin(Id, con);

			sb.setKaiinId(kv.getKaiinno());
			sb.setKaiinName(kv.getName());
			sb.setTourokubi(kv.getRegistdate());

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return sb;

	}

	public RegistBean setKaiin(int id, String name, String sex) {

		RegistBean rb = new RegistBean();
		try (Connection con = Dao.getConnection();) {

			KaiinVo kv = mgr.registKaiin(id, con);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return rb;
	}
}
