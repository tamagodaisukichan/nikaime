package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import domain.SexEnum;
//import data.Kaiin;
import vo.KaiinVo;

public class KaiinMgr {

    public KaiinMgr() {

    }

    final static String INSERT_SQL = "INSERT INTO " +
            "kaiin " +
            "( kaiinNo " +
            ",name " +
            ",sex " +
            ",registDate ) " +
            "VALUES (?, ?, ?, ?);";

    final static String SEARCH_SQL = "SELECT " +
            "* " +
            "FROM " +
            "kaiin " +
            "WHERE " +
            "kaiinNo = ?;";

    final static String ALL_SQL = "SELECT " +
            "* " +
            "FROM " +
            "kaiin ;";

    // 検索
    public KaiinVo searchKaiin(int i, Connection con) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        KaiinVo k = new KaiinVo();

        try {

            /* Statkentの作成 */
            stmt = con.prepareStatement(SEARCH_SQL);

            stmt.setInt(1, i);

            /* ｓｑｌ実行 */
            rset = stmt.executeQuery();

            /* 取得したデータを表示します。 */
            while (rset.next()) {

                //k.setkployeeid(rset.getInt("kPLOYEEID") );
                k.setKaiinno	(rset.getInt(1));
                k.setName		(rset.getString(2));
                k.setSex			(rset.getString(3));
                k.setRegistdate		(rset.getDate(4));
                //Systk.out.println(rset.getString(1));
            }
        }

        catch (SQLException e) {
            throw e;
        }

        return k;
    }

    //会員登録
    public KaiinVo registKaiin(int id, String name, SexEnum sex, Connection con) throws SQLException {

        PreparedStatement stmt = null;
        KaiinVo k = new KaiinVo(id, name, sex);

        try {
            /* Statkentの作成 */
            stmt = con.prepareStatement(INSERT_SQL);

            stmt.setInt		(1, k.getKaiinno());
            stmt.setString	(2, k.getName());
            stmt.setString	(3, k.getSex());
            stmt.setDate	(4, new java.sql.Date(k.getRegistdate().getTime()));
            @SuppressWarnings("unused")
            int num=stmt.executeUpdate();
        }
        catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("入力した会員番号は既に使用されています");
        }
        return k;
    }

    // 会員情報を全件取得
    public List<KaiinVo> allKaiin(Connection con) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rset = null;

        List<KaiinVo> list = new ArrayList<KaiinVo>();

        try {

            /* Statkentの作成 */
            stmt = con.prepareStatement(ALL_SQL);

            /* ｓｑｌ実行 */
            rset = stmt.executeQuery();

            /* 取得したデータを表示します。 */
            while (rset.next()) {
                KaiinVo k = new KaiinVo();
                k.setKaiinno	(rset.getInt(1));
                k.setName		(rset.getString(2));
                k.setSex		(rset.getString(3));
                k.setRegistdate	(rset.getDate(4));
                list.add(k);

            }
        }

        catch (SQLException e) {
            throw e;
        }

        return list;

    }

}