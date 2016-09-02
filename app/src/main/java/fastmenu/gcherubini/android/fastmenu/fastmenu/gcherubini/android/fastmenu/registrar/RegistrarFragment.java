package fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.registrar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import fastmenu.gcherubini.android.fastmenu.R;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Mask;
import fastmenu.gcherubini.android.fastmenu.fastmenu.gcherubini.android.fastmenu.superclasses.Usuario;

/**
 * Created by G.Cherubini on 09/08/2016.
 */
public class RegistrarFragment extends Fragment
{
    //Declaração dos widgets do fragment
    protected Button mRegistrarButtonRegistrar;
    protected EditText mNomeEditTextRegistrar;
    protected EditText mSobrenomeEditTextRegistrar;
    protected EditText mTelefoneEditTextRegistrar;
    protected EditText mCPFEditTextRegistrar;
    protected EditText mEmailEditTextRegistrar;
    protected EditText mSenhaEditTextRegistrar;
    protected EditText mSenha2EditTextRegistrar;

    protected TextView mTelefoneTextViewRegistrar;
    protected TextView mCPFTextViewRegistrar;
    protected TextView mSenhaTextViewRegistrar;
    protected TextView mSenha2TextViewRegistrar;
    protected TextView mFlagTextViewRegistrar;

    private boolean flagErro;

    protected Usuario mUsuario;
    protected RegistrarUsuario mRegistrarUsuario;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_registrar, container, false);

        //Referências dos TextViews de verificação
        mTelefoneTextViewRegistrar = (TextView)v.findViewById(R.id.telefone_textView);
        mCPFTextViewRegistrar = (TextView)v.findViewById(R.id.cpf_textView);
        mSenhaTextViewRegistrar = (TextView)v.findViewById(R.id.senha_textView);
        mSenha2TextViewRegistrar = (TextView)v.findViewById(R.id.senha2_textView);
        mFlagTextViewRegistrar = (TextView)v.findViewById(R.id.flagRegistrar_textView);


        //Definindo as referências dos EditText
        mNomeEditTextRegistrar = (EditText)v.findViewById(R.id.nomeRegistrar_editText);
        mSobrenomeEditTextRegistrar = (EditText)v.findViewById(R.id.sobrenomeRegistrar_editText);
        mEmailEditTextRegistrar = (EditText)v.findViewById(R.id.emailRegistrar_editText);
        mSenhaEditTextRegistrar = (EditText)v.findViewById(R.id.senhaRegistrar_editText);
        mSenha2EditTextRegistrar = (EditText)v.findViewById(R.id.senha2Registrar_editText);

        //Campos com máscaras
        mTelefoneEditTextRegistrar = (EditText)v.findViewById(R.id.telefoneRegistrar_editText);
        mCPFEditTextRegistrar = (EditText)v.findViewById(R.id.cpfRegistrar_editText);

        //Adicionando máscaras aos campos
        mTelefoneEditTextRegistrar.addTextChangedListener(Mask.insert(false, mTelefoneEditTextRegistrar));
        mCPFEditTextRegistrar.addTextChangedListener(Mask.insert(true, mCPFEditTextRegistrar));

        //Deixando o valor inicial das strings como null
        mNomeEditTextRegistrar.setText(null);
        mSobrenomeEditTextRegistrar.setText(null);
        mTelefoneEditTextRegistrar.setText(null);
        mCPFEditTextRegistrar.setText(null);
        mEmailEditTextRegistrar.setText(null);
        mSenhaEditTextRegistrar.setText(null);
        mSenha2EditTextRegistrar.setText(null);

        for(int i = 0; i < VerificaFormulario.fieldStatusErro.length; i++)
        {
            VerificaFormulario.fieldStatusErro[i] = false;
        }

        //Click Listener no botão "Registrar"
        mRegistrarButtonRegistrar = (Button)v.findViewById(R.id.registrarRegistrar_button);
        mRegistrarButtonRegistrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loop:
                for(int i = 0; i < VerificaFormulario.fieldStatusErro.length; i++)
                {
                    flagErro = false;
                    //Array fieldStatusErro: Pos1 = Tel inválido, Pos2 = CPF inválido, Pos3 = CPF já registrado, Pos4 = Senha inválida, Pos5 = Senhas divergem
                    if(VerificaFormulario.fieldStatusErro[i])
                    {
                        switch (i)
                        {
                            case 0:
                                mFlagTextViewRegistrar.setText(R.string.telefoneInvalido_string);
                                mTelefoneEditTextRegistrar.requestFocus();
                                flagErro = true;
                                break loop;
                            case 1:
                                mFlagTextViewRegistrar.setText(R.string.CPFInvalido_string);
                                mCPFEditTextRegistrar.requestFocus();
                                flagErro = true;
                                break loop;
                            case 2:
                                mFlagTextViewRegistrar.setText(R.string.CPFRegistrado_string);
                                mCPFEditTextRegistrar.requestFocus();
                                flagErro = true;
                                break loop;
                            case 3:
                                mFlagTextViewRegistrar.setText(R.string.senhaInvalida_string);
                                mSenhaEditTextRegistrar.requestFocus();
                                flagErro = true;
                                break loop;
                            case 4:
                                mFlagTextViewRegistrar.setText(R.string.senhaDiferente_string);
                                mSenha2EditTextRegistrar.requestFocus();
                                flagErro = true;
                                break loop;
                            default:
                                mFlagTextViewRegistrar.setText("");
                                flagErro = true;
                                break loop;
                        }
                    }
                }

                if (!flagErro)
                {
                    if(VerificaFormulario.isComplete(new String[] {mNomeEditTextRegistrar.getText().toString(), mSobrenomeEditTextRegistrar.getText().toString(),
                            mTelefoneEditTextRegistrar.getText().toString(), mCPFEditTextRegistrar.getText().toString(), mEmailEditTextRegistrar.getText().toString(),
                            mSenhaEditTextRegistrar.getText().toString(),  mSenha2EditTextRegistrar.getText().toString()}))
                    {
                        //Inicializando classe para registro dos usuários
                        mUsuario = new Usuario(mNomeEditTextRegistrar.getText().toString(), mSobrenomeEditTextRegistrar.getText().toString(),
                                mTelefoneEditTextRegistrar.getText().toString(), mCPFEditTextRegistrar.getText().toString(), mEmailEditTextRegistrar.getText().toString(),
                                mSenhaEditTextRegistrar.getText().toString());

                        mRegistrarUsuario = new RegistrarUsuario(mUsuario);
                    }
                    else
                    {
                        mFlagTextViewRegistrar.setText(R.string.camposVazios_string);
                    }
                }
            }
        });

        mTelefoneEditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (mTelefoneEditTextRegistrar.getText().toString().length() == 0)
                {
                    mTelefoneTextViewRegistrar.setText("");
                    VerificaFormulario.fieldStatusErro[0] = true;
                }
                else
                {
                    if (VerificaFormulario.isTelOK(mTelefoneEditTextRegistrar.getText().toString()))
                    {
                        mTelefoneTextViewRegistrar.setText(R.string.ok_string);
                        mFlagTextViewRegistrar.setText("");
                        VerificaFormulario.fieldStatusErro[0] = false;
                    } else
                    {
                        mTelefoneTextViewRegistrar.setText(R.string.telefoneInvalido_string);
                        VerificaFormulario.fieldStatusErro[0] = true;
                    }
                }
            }
        });

        mCPFEditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (mCPFEditTextRegistrar.getText().toString().length() == 0)
                {
                    mCPFTextViewRegistrar.setText("");
                    VerificaFormulario.fieldStatusErro[1] = true;
                    VerificaFormulario.fieldStatusErro[2] = true;
                }
                else
                {
                    if (VerificaFormulario.isCPFOK(mCPFEditTextRegistrar.getText().toString()) &&
                            VerificaFormulario.isCPFAvailable(mCPFEditTextRegistrar.getText().toString()))
                    {
                        mCPFTextViewRegistrar.setText(R.string.ok_string);
                        mFlagTextViewRegistrar.setText("");
                        VerificaFormulario.fieldStatusErro[1] = false;
                        VerificaFormulario.fieldStatusErro[2] = false;
                    } else
                    {
                        if (!VerificaFormulario.isCPFOK(mCPFEditTextRegistrar.getText().toString()))
                        {
                            mCPFTextViewRegistrar.setText(R.string.CPFInvalido_string);
                            VerificaFormulario.fieldStatusErro[1] = true;
                        } else if (!VerificaFormulario.isCPFAvailable(mCPFEditTextRegistrar.getText().toString()))
                        {
                            mCPFTextViewRegistrar.setText(R.string.CPFRegistrado_string);
                            VerificaFormulario.fieldStatusErro[2] = true;
                        }
                    }
                }
            }
        });

        mSenhaEditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (mSenhaEditTextRegistrar.getText().toString().length() == 0)
                {
                    mSenhaTextViewRegistrar.setText("");
                    VerificaFormulario.fieldStatusErro[2] = true;
                }
                else
                {
                    if (VerificaFormulario.isPasswordOk(mSenhaEditTextRegistrar.getText().toString()))
                    {
                        mSenhaTextViewRegistrar.setText(R.string.ok_string);
                        mFlagTextViewRegistrar.setText("");
                        VerificaFormulario.fieldStatusErro[2] = false;
                    } else
                    {
                        mSenhaTextViewRegistrar.setText(R.string.senhaInvalida_string);
                        VerificaFormulario.fieldStatusErro[2] = true;
                    }
                }
            }
        });

        mSenha2EditTextRegistrar.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (mSenha2EditTextRegistrar.getText().toString().length() == 0)
                {
                    mSenha2TextViewRegistrar.setText("");
                    VerificaFormulario.fieldStatusErro[3] = true;
                }
                else
                {
                    if (VerificaFormulario.arePasswordsSame(mSenhaEditTextRegistrar.getText().toString(), mSenha2EditTextRegistrar.getText().toString()))
                    {
                        mSenha2TextViewRegistrar.setText(R.string.ok_string);
                        mFlagTextViewRegistrar.setText("");
                        VerificaFormulario.fieldStatusErro[3] = false;
                    }
                    else
                    {
                        mSenha2TextViewRegistrar.setText(R.string.senhaDiferente_string);
                        VerificaFormulario.fieldStatusErro[3] = true;
                    }
                }


            }

        });

        return v;

    }

}
