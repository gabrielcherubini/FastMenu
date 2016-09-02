package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by G.Cherubini on 26/08/2016.
 */
public abstract class Mask
{

    public static final String tel8 = "(##)####-####";
    public static final String telDefault = "####-####";
    public static final String tel9 = "(##)#####-####";
    public static final String cpf = "###.###.###-##";


    public static String unmask(String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }

    public static TextWatcher insert(final boolean isCPF, final EditText ediTxt)
    {
        return new TextWatcher()
        {
            boolean isUpdating;
            String old = "";

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String str = Mask.unmask(s.toString());
                String mascara = "";
                String mask;
                String defaultMask = getDefaultMask(str);

                if (isCPF)
                {
                    mask = cpf;
                }
                else
                {
                    switch (str.length())
                    {
                        case 11:
                            mask = tel9;
                            break;
                        case 10:
                            mask = tel8;
                            break;
                        default:
                            mask = defaultMask;
                            break;
                    }
                }

                if (isUpdating)
                {
                    old = str;
                    isUpdating = false;
                    return;
                }

                int i = 0;
                for (char m : mask.toCharArray())
                {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i))
                    {
                        mascara += m;
                        continue;
                    }
                    try
                    {
                        mascara += str.charAt(i);
                    }
                    catch (Exception e)
                    {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                ediTxt.setText(mascara);
                ediTxt.setSelection(mascara.length());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        };
    }
    private static String getDefaultMask(String str)
    {
        String defaultMask = telDefault;
        if (str.length() > 11)
        {
            defaultMask = tel9;
        }
        return defaultMask;
    }
}
