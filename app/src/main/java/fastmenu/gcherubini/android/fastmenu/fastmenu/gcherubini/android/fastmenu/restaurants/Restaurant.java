package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.restaurants;

import java.util.UUID;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.interfaces.QueryRestaurantes;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu.MenuRestaurant;

/**
 * Created by G.Cherubini on 03/09/2016.
 */
public class Restaurant implements QueryRestaurantes
{
    private int mID;            //ID do restaurante na base de dados
    private String mNome;
    private String mEndereço;
    private String mTelefone;
    private String mCNPJ;
    private String mInfo;
    private String mDistância;

    private MenuRestaurant mMenuRestaurant;

    //Constructor sem argumentos
    public Restaurant() {}

    //Constructor com argumento de ID para buscar na base
    public Restaurant(int id)
    {
        setID(id);
    }

    public int getID()
    {
        return mID;
    }

    public String getNome()
    {
        return mNome;
    }

    public String getEndereço()
    {
        return mEndereço;
    }

    public String getTelefone()
    {
        return mTelefone;
    }

    public String getCNPJ()
    {
        return mCNPJ;
    }

    public String getInfo()
    {
        return mInfo;
    }

    public String getDistância()
    {
        return mDistância;
    }

    //Setters
    public void setID(int ID)
    {
        mID = ID;
    }

    public void setNome(String nome)
    {
        mNome = nome;
    }

    public void setEndereço(String endereço)
    {
        mEndereço = endereço;
    }

    public void setTelefone(String telefone)
    {
        mTelefone = telefone;
    }

    public void setCNPJ(String CNPJ)
    {
        mCNPJ = CNPJ;
    }

    public void setInfo(String info)
    {
        mInfo = info;
    }

    public void setDistância(String distância)
    {
        mDistância = distância;
    }


    //Getter e setter para a variavel que guarda o menu
    public MenuRestaurant getMenuRestaurant()
    {
        return mMenuRestaurant;
    }

    public void setMenuRestaurant(MenuRestaurant menu)
    {
        mMenuRestaurant = menu;
    }

    //Metodo para buscar o menu da base de dados
    public void fetchMenu()
    {

    }

    //Implementação dos métodos abstratos da interface QueryRestaurantes
    //para buscar informações na base de dados
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

    public String queryInfo(int id)
    {
        return "";
    }

    //Método para calcular a distância do restaurante até dada posição
    public String calculateDistance(double latitude, double longitude)
    {
        return "600m";
    }



}
