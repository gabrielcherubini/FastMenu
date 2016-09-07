package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu;

import java.math.BigDecimal;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.interfaces.QueryItem;

/**
 * Created by G.Cherubini on 06/09/2016.
 */
public class MenuItem implements QueryItem
{
    private String mNome;
    private String mDescrição;
    private BigDecimal mPreço;
    private String mTipo;

    public MenuItem(int i)
    {
        setNome(queryNome(i));
        setDescrição(queryDescrição(i));
        setPreço(queryPreço(i));
        setTipo(queryTipo(i));
    }

    //Getters
    public String getNome()
    {
        return mNome;
    }

    public String getDescrição()
    {
        return mDescrição;
    }

    public BigDecimal getPreço()
    {
        return mPreço;
    }

    public String getTipo()
    {
        return mTipo;
    }

    //Setters
    public void setNome(String nome)
    {
        mNome = nome;
    }

    public void setDescrição(String descrição)
    {
        mDescrição = descrição;
    }

    public void setPreço(BigDecimal preço)
    {
        mPreço = preço;
    }

    public void setTipo(String tipo)
    {
        mTipo = tipo;
    }

    //TODO: métodos para buscar as informações da base de dados
    public String queryNome(int i)
    {
        return "";
    }

    public String queryDescrição(int i)
    {
        return "";
    }

    public BigDecimal queryPreço(int i)
    {
        return (new BigDecimal("0"));
    }

    public String queryTipo(int i)
    {
        return "";
    }

}
