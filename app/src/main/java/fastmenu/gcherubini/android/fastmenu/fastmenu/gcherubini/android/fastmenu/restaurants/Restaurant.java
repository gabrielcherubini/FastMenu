package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants;

import java.util.UUID;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.interfaces.QueryRestaurantes;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu.Menu;

/**
 * Created by G.Cherubini on 03/09/2016.
 */
public class Restaurant implements QueryRestaurantes
{
    protected UUID mUUID;       //Para preenchimento da lista de restaurantes
    protected int mID;          //ID do restaurante na base de dados
    protected String mNome;
    protected String mEndereço;
    protected Menu mMenu;
    protected String mTelefone;
    protected String mCNPJ;

    //Constructor sem argumentos
    public Restaurant() {}

    //Constructor com argumento de ID para buscar na base
    public Restaurant(int id)
    {
        setID(id);
    }

    public UUID getUUID()
    {
        return mUUID;
    }

    public void setUUID(UUID id)
    {
        mUUID = id;
    }

    public String getNome()
    {
        return mNome;
    }

    public int getID()
    {
        return mID;
    }

    public void setID(int ID)
    {
        mID = ID;
    }

    public void setNome(String nome)
    {
        mNome = nome;
    }

    public String getEndereço()
    {
        return mEndereço;
    }

    public void setEndereço(String endereço)
    {
        mEndereço = endereço;
    }

    public Menu getMenu()
    {
        return mMenu;
    }

    public void setMenu(Menu menu)
    {
        mMenu = menu;
    }

    public String getTelefone()
    {
        return mTelefone;
    }

    public void setTelefone(String telefone)
    {
        mTelefone = telefone;
    }

    public String getCNPJ()
    {
        return mCNPJ;
    }

    public void setCNPJ(String CNPJ)
    {
        mCNPJ = CNPJ;
    }

    public String queryNome(int id)
    {
        return "";
    }

    public String queryEndereço(int id)
    {
        return "";
    }
    public String queryTelefone(int id)
    {
        return "";
    }

    public String queryCNPJ(int id)
    {
        return "";
    }
}
