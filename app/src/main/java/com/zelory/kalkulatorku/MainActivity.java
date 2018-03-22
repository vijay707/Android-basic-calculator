package com.zelory.kalkulatorku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener
{

    private TextView teks;
    private String kiri = "", kanan = "", soal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (savedInstanceState != null)
            teks.setText(savedInstanceState.getString("teks"));
    }

    private void init()
    {
        Button satu;
        Button dua;
        Button tiga;
        Button empat;
        Button lima;
        Button enam;
        Button tujuh;
        Button delapan;
        Button sembilan;
        Button nol;
        Button tambah;
        Button kurang;
        Button kali;
        Button bagi;
        Button hapus;
        Button hapusSemua;
        Button samaDengan;

        teks = (TextView) findViewById(R.id.textView);
        nol = (Button) findViewById(R.id.button0);
        satu = (Button) findViewById(R.id.button1);
        dua = (Button) findViewById(R.id.button2);
        tiga = (Button) findViewById(R.id.button3);
        empat = (Button) findViewById(R.id.button4);
        lima = (Button) findViewById(R.id.button5);
        enam = (Button) findViewById(R.id.button6);
        tujuh = (Button) findViewById(R.id.button7);
        delapan = (Button) findViewById(R.id.button8);
        sembilan = (Button) findViewById(R.id.button9);
        tambah = (Button) findViewById(R.id.tambah);
        kurang = (Button) findViewById(R.id.kurang);
        kali = (Button) findViewById(R.id.kali);
        bagi = (Button) findViewById(R.id.bagi);
        hapus = (Button) findViewById(R.id.del);
        hapusSemua = (Button) findViewById(R.id.hapus);
        samaDengan = (Button) findViewById(R.id.hasil);

        nol.setOnClickListener(this);
        satu.setOnClickListener(this);
        dua.setOnClickListener(this);
        tiga.setOnClickListener(this);
        empat.setOnClickListener(this);
        lima.setOnClickListener(this);
        enam.setOnClickListener(this);
        tujuh.setOnClickListener(this);
        delapan.setOnClickListener(this);
        sembilan.setOnClickListener(this);
        tambah.setOnClickListener(this);
        kurang.setOnClickListener(this);
        kali.setOnClickListener(this);
        bagi.setOnClickListener(this);
        hapus.setOnClickListener(this);
        hapusSemua.setOnClickListener(this);
        samaDengan.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("teks", teks.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.button0)
        {
            awal();
            teks.setText(teks.getText() + "0");
        } else if (v.getId() == R.id.button1)
        {
            awal();
            teks.setText(teks.getText() + "1");
        } else if (v.getId() == R.id.button2)
        {
            awal();
            teks.setText(teks.getText() + "2");
        } else if (v.getId() == R.id.button3)
        {
            awal();
            teks.setText(teks.getText() + "3");
        } else if (v.getId() == R.id.button4)
        {
            awal();
            teks.setText(teks.getText() + "4");
        } else if (v.getId() == R.id.button5)
        {
            awal();
            teks.setText(teks.getText() + "5");
        } else if (v.getId() == R.id.button6)
        {
            awal();
            teks.setText(teks.getText() + "6");
        } else if (v.getId() == R.id.button7)
        {
            awal();
            teks.setText(teks.getText() + "7");
        } else if (v.getId() == R.id.button8)
        {
            awal();
            teks.setText(teks.getText() + "8");
        } else if (v.getId() == R.id.button9)
        {
            awal();
            teks.setText(teks.getText() + "9");
        } else if (v.getId() == R.id.tambah)
        {
            if (valid())
                teks.setText(teks.getText() + "+");
        } else if (v.getId() == R.id.kurang)
        {
            if (valid())
                teks.setText(teks.getText() + "-");
        } else if (v.getId() == R.id.kali)
        {
            if (valid())
                teks.setText(teks.getText() + "*");
        } else if (v.getId() == R.id.bagi)
        {
            if (valid())
                teks.setText(teks.getText() + "÷");
        } else if (v.getId() == R.id.del)
        {
            hapusAngka();
        } else if (v.getId() == R.id.hapus)
        {
            teks.setText("0");
        } else if (v.getId() == R.id.hasil)
        {
            hitung();
        }
    }

    void awal()
    {
        if (teks.getText().toString().equals("0"))
            teks.setText("");
    }

    void hapusAngka()
    {
        int panjang = teks.getText().toString().length();
        if (panjang > 0)
        {
            String temp = teks.getText().toString().substring(0, panjang - 1);
            teks.setText(temp);
        }
        if (teks.getText().toString().equals(""))
            teks.setText("0");
    }

    boolean valid()
    {
        char akhir = teks.getText().toString().toCharArray()[teks.getText().length() - 1];
        return !(akhir == '+' || akhir == '-' || akhir == '*' || akhir == '÷' || teks.getText().toString().equals("0"));
    }

    void hitung()
    {
        soal = teks.getText().toString();
        soal = soal.replace('-', '_');
        if (stringDi(soal, 0).equals("_"))
            soal = "-" + soal.substring(1);

        if (stringDi(soal, soal.length() - 1).equals("+") || stringDi(soal, soal.length() - 1).equals("_") || stringDi(soal, soal.length() - 1).equals("*") || stringDi(soal, soal.length() - 1).equals("÷"))
            soal = soal.substring(0, soal.length() - 1);

        while (operasi(soal, "*", "÷")) ;
        while (operasi(soal, "+", "_")) ;

        teks.setText(soal);
    }

    String stringDi(String string, int pos)
    {
        return string.substring(pos, pos + 1);
    }

    boolean operasi(String soal, String op1, String op2)
    {
        boolean ada = false;
        for (int i = 0; i < soal.length(); i++)
        {
            if (stringDi(soal, i).equals(op1))
            {
                ada = true;
                Long x = 0l;
                switch (op1)
                {
                    case "*":
                        x = ambilAngkaKiri(soal, i) * ambilAngkaKanan(soal, i);
                        break;
                    case "÷":
                        if (ambilAngkaKanan(soal, i) != 0)
                            x = ambilAngkaKiri(soal, i) / ambilAngkaKanan(soal, i);
                        else
                            x = Long.MAX_VALUE;
                        break;
                    case "+":
                        x = ambilAngkaKiri(soal, i) + ambilAngkaKanan(soal, i);
                        break;
                    case "_":
                        x = ambilAngkaKiri(soal, i) - ambilAngkaKanan(soal, i);
                        break;
                }

                this.soal = kiri + x + kanan;
                break;
            } else if (stringDi(soal, i).equals(op2))
            {
                ada = true;
                Long x = 0l;
                switch (op2)
                {
                    case "*":
                        x = ambilAngkaKiri(soal, i) * ambilAngkaKanan(soal, i);
                        break;
                    case "÷":
                        if (ambilAngkaKanan(soal, i) != 0)
                            x = ambilAngkaKiri(soal, i) / ambilAngkaKanan(soal, i);
                        else
                            x = Long.MAX_VALUE;
                        break;
                    case "+":
                        x = ambilAngkaKiri(soal, i) + ambilAngkaKanan(soal, i);
                        break;
                    case "_":
                        x = ambilAngkaKiri(soal, i) - ambilAngkaKanan(soal, i);
                        break;
                }
                this.soal = kiri + x + kanan;
                break;
            }
        }

        return ada;
    }

    Long ambilAngkaKiri(String soal, int pos)
    {
        String tmp;
        kiri = "";
        int i;
        for (i = pos - 1; i >= 0; i--)
        {
            if (stringDi(soal, i).equals("+") || stringDi(soal, i).equals("_") || stringDi(soal, i).equals("*") || stringDi(soal, i).equals("÷"))
                break;
        }
        tmp = soal.substring(i + 1, pos);
        kiri = soal.substring(0, i + 1);
        return Long.parseLong(tmp);
    }

    Long ambilAngkaKanan(String soal, int pos)
    {
        String tmp;
        kanan = "";
        int i;
        for (i = pos + 1; i < soal.length(); i++)
        {
            if (stringDi(soal, i).equals("+") || stringDi(soal, i).equals("_") || stringDi(soal, i).equals("*") || stringDi(soal, i).equals("÷"))
                break;
        }
        tmp = soal.substring(pos + 1, i);
        kanan = soal.substring(i, soal.length());
        return Long.parseLong(tmp);
    }
}
