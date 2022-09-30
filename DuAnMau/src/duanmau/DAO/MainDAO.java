/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.DAO;

import java.util.List;


/**
 *
 * @author NguyenMinhHau_PS24488
 */
public abstract class MainDAO<E, K> {

    public abstract void Update(E entity);

    public abstract void Insert(E entity);
//     public abstract void Create(E entyti, K keytype);

    public abstract void Remove(K keytype);

    public abstract E EntytiType(K keytype);
    
    public abstract E SelectID(K id);

    public abstract List<E> SelectAll();
    

    protected abstract List<E> SelectBySql(String sql, Object... args);
}
