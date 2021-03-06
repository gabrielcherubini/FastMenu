package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G.Cherubini on 06/09/2016.
 */
public class MenuRestaurant
{

    //Variável estática para criar unica instancia da classe (singleton)
    private static MenuRestaurant sMenuRestaurant;

    private List<MenuItem> mItemListEntrada;
    private List<MenuItem> mItemListPratoPrincipal;
    private List<MenuItem> mItemListSobremesa;
    private List<MenuItem> mItemListBebida;
    private List<MenuItem> mItemListOutro;
    private List<MenuItem> mItemListPromoção;

    //ID do menu (igual à do restaurante)
    private int mID;

    //Método da singleton para instanciar uma classe menu nova caso nenhuma instancia tenha sido identificada
    public static MenuRestaurant get(Context context, int id)
    {
        if (sMenuRestaurant == null)
        {
            sMenuRestaurant = new MenuRestaurant(context, id);
        }
        return sMenuRestaurant;
    }

    //Constructor. Argumento ID passado do restaurante e usado para buscar o menu relativo à aquele restaurante
    private MenuRestaurant(Context context, int id)
    {
        setID(id);
        createLists();
    }

    //Getters
    public List<MenuItem> getItemListEntrada()
    {
        return mItemListEntrada;
    }

    public List<MenuItem> getItemListPratoPrincipal()
    {
        return mItemListPratoPrincipal;
    }

    public List<MenuItem> getItemListSobremesa()
    {
        return mItemListSobremesa;
    }

    public List<MenuItem> getItemListBebida()
    {
        return mItemListBebida;
    }

    public List<MenuItem> getItemListOutro()
    {
        return mItemListOutro;
    }

    public List<MenuItem> getItemListPromoção()
    {
        return mItemListPromoção;
    }

    public int getID()
    {
        return mID;
    }

    public void setID(int ID)
    {
        mID = ID;
    }


    //Método para buscar a quantidade de itens no menu do restaurante a partir da ID dada
    private int findItemsNumber(int id)
    {
        int num = 10; //Integer para buscar a quantidade de itens no menu do restaurante dado pela ID
        return num;
    }

    //Método para criar as listas de cada tipo de produto vendido pelo restaurante
    private void createLists()
    {
        //Cria arraylists para guardar os items de cada tipo
        mItemListEntrada = new ArrayList<>();
        mItemListPratoPrincipal = new ArrayList<>();
        mItemListSobremesa = new ArrayList<>();
        mItemListBebida = new ArrayList<>();
        mItemListOutro = new ArrayList<>();
        mItemListPromoção = new ArrayList<>();

        //Declaração da variavel que guarda uma instancia de um item
        MenuItem item;

        //Loopa i da primeira até a ultima entrada disponivel na base de dados do menu
        for (int i = 1; i <= findItemsNumber(mID); i++)
        {
            item = new MenuItem(i);

            //Switch do tipo do item encontrado na posição i da base de dados do menu do restaurante dado pela id
            //e adiciona a entrada na lista correspondente a partir do tipo
            switch(item.getTipo())
            {
                case "ENTRADA":
                    mItemListEntrada.add(item);
                    break;
                case "PRATO PRINCIPAL":
                    mItemListPratoPrincipal.add(item);
                    break;
                case "SOBREMESA":
                    mItemListSobremesa.add(item);
                    break;
                case "BEBIDA":
                    mItemListBebida.add(item);
                    break;
                case "OUTRO":
                    mItemListOutro.add(item);
                    break;
                case "PROMOÇÃO":
                    mItemListOutro.add(item);
                    break;
                default: //Se o campo estiver vazio, agrupar em outros
                    mItemListOutro.add(item);
                    break;
            }
        }
    }
}
