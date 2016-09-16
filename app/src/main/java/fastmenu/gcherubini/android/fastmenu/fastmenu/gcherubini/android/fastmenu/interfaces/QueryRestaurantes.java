package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.interfaces;

import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.menu.MenuRestaurant;

/**
 * Created by G.Cherubini on 06/09/2016.
 */
public interface QueryRestaurantes
{
    String queryNome(int id);
    String queryEndereço(int id);
    String queryTelefone(int id);
    String queryCNPJ(int id);
    String queryInfo(int id);
}
