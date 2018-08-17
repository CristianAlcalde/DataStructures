package montoEscrito_pkg;
//import java.util.Scanner;
public class MontoEscrito {
    
    public String EscribirMonto(int Num) {
        //Presentar el programa
            //System.out.println ("UTP:::IS304-Estructuras_de_Datos::1088333702:DanielAlarcon");
            //System.out.println ("\tPrograma Monto Escrito");
        //Pedir ingreso de los n�meros
            //System.out.println ("\tIngresa un n�mero de hasta 4 d�gitos");
        //Inicializar esc�ner de entrada de teclado
        //!!!!!Fragmento tomado de internet !!!!! ------------
            //Scanner Lector = new Scanner(System.in);
        //Leer el n�mero y separarlo en un array de 4 posiciones
        //Ser� tratado como un string dado que me dan lidia los int
            //String NumBase = "";
            //NumBase = Lector.nextLine();
        //Variable para retornar
   	 	String NumBase = String.valueOf(Num);
            String Resultado = "";
        //Separarlo
            String[] NumBase_arr = NumBase.split("");
        //Contar la cantida de d�gitos ingresados
            int NumBase_arr_size = NumBase_arr.length;
            //System.out.println("\tLongitud del array: \"" + NumBase_arr_size +"\"");
            //Seg�n solicitud del docente, no exceder m�s de 4 d�gitos
            if(NumBase_arr_size<5) {
                //No se exceden los 4 d�gitos
                //System.out.println("Continuar");
                String CadenaMil = ""; //String para almacenar el monto de miles
                String CadenaCien = ""; //String para almacenar el monto de cientos
                String CadenaDiez = ""; //String para almacenar el monto de decenas
                String CadenaUno = ""; //String para almacenar el monto de unidades
                if(NumBase_arr_size==1){
                    //El n�mero ingresado es de un solo d�gito, indicarlo directamente
                 CadenaUno = Unidades(NumBase_arr[0]);
                 Resultado = CadenaUno;
                 return Resultado;
                 //System.out.println(CadenaUno);
                }else{
                   //El n�mero ingresado es de 2+ d�gitos
                 //Determinar las posiciones num�ricas m/c/d/u
                    int PosicionNumerica = NumBase_arr_size ;
                    for (int i=0; i<=(NumBase_arr_size-1); i++) {
                        //Miles 1000->9000
                        if(PosicionNumerica==4){CadenaMil=Mil(NumBase_arr[i]);}
                        /*
                                    Problem�tica en Centenas
                                    Se tiene 125 el sistema puede decir "cien veinticinco"
                                    Si al unificar centena, decena y unidad resulta en "100" autom�ticamente decir "cien",
                                    caso contrario, ej.: 103, 113, dir� inicialmente "ciento"
                        */
                        //Centenas 100->900
                        if(PosicionNumerica==3){
                        	String Centena = NumBase_arr[i]+NumBase_arr[i+1]+NumBase_arr[i+2];
                        	switch(Centena) {
	                        	case "100":
	                        		CadenaCien = "cien";
	                     		break;
	                        		
                        		default:
                        			CadenaCien = Centenas(NumBase_arr[i]);
                     			break;
                        		
                        	}
                        	
                        }
                        
                        /*
                         Problem�tica en Decenas
                         Tenemos 11, el sistema puede decir "diez y uno"
                         Si decena est� entre 1 y 2 && unidad es diferente de 0
                         Entonces decena.unidad 
                        */
                            
                        //Decenas 10->90
                        if(PosicionNumerica==2){
                        	/*
                        	int 7702535010341
                        	String Decena = NumBase_arr[i]+NumBase_arr[i+1];
									//System.out.println(Decena);
                        	if(Decenas(Decena)=="") {System.out.println("El n�mero es a partir de 3+");}else {System.out.println("Ya que");}
                        	//if(NumBase_arr[i]=="0") {System.out.println("NO SE EJECUTA UNIDAD");}else {System.out.println("SE EJECUTA UNIDAD");}
                        	/*
                            
                            */
                        	int PosSiguiente=i+1;
                            switch(NumBase_arr[i]) {
	                            case "1":
	                            case "2":
	                            //Est� entre uno y 2
	                           	 //Verificar que la unidad no sea 0
	                             if(NumBase_arr[PosSiguiente]=="0") {
	                           	  //Unidad es 0 por lo tanto permitir las decenas comunes y las unidades comunes
	                                CadenaDiez = Decenas(NumBase_arr[i]);
	                             }else{
	                                 //Unidad es diferente de 0 por lo tanto usar decenas concatenadas y anular unidades
	                                 String NewNum = NumBase_arr[i]+NumBase_arr[PosSiguiente];
	                                 CadenaDiez = Decenas(NewNum);
	                             }
	                           break;
                           
	                           default:
	                           	CadenaDiez = Decenas(NumBase_arr[i]);
	                           break;
                            }
                        }
                        
                        //Unidades 1->9
                        if(PosicionNumerica==1){
                        	int Pos_Decenas=i-1;
                        	switch(NumBase_arr[Pos_Decenas]) {
                        	case "1":
                        	case "2":
                        		//Nothing
                     		break;
                     		
                     		default:
                     			CadenaUno=Unidades(NumBase_arr[i]);
                     			break;
                        	}
                            /*if(NumBase_arr[i-1]=="1" || NumBase_arr[i-1]=="2") {
                                //CadenaUno=Unidades(NumBase_arr[i]);
                                //System.out.println("ENTRA A BUSCAR  UNIDAD");
                            }
                            else
                            {
                           	 CadenaUno=Unidades(NumBase_arr[i]);
                            }*/
                        }
                        
                        //Cambiar la posici�n num�rica Miles->Centenas->Decenas->Unidades
                        PosicionNumerica--;
                    }
                    /**/
                   // System.out.println("\tEl resultado del n�mero ingresado " + NumBase + " es:");
                    //Control para a�adidura del "y", aplicar solo cuando CadenaUno sea diferente de vac�o.
                    if(CadenaUno != "") {CadenaUno=" y"+CadenaUno;}
                    //System.out.println("\n\tMonto: " + CadenaMil + " " + CadenaCien + " " + CadenaDiez + " " + CadenaUno + " ");
                    Resultado = CadenaMil + CadenaCien + CadenaDiez + CadenaUno;
                    return Resultado;
                }
                
            }else {
                //Se exceden los 4 d�gitos
                //System.out.println("\tError. El programa fue solicitado para m�ximo 4 d�gitos.\n\tSe detiene el programa");
            	Resultado = "Error. El programa fue solicitado para m�ximo 4 d�gitos.";
            	return Resultado;
            }
            
//        return Resultado;
        
    }//cierre public string montoEscrito
   
  //M�todo para determinar Unidades
    public static String Unidades(String Num) {
     String r="";
     switch(Num) {
         case "1":
             r = " uno";
             break;
             
         case "2":
             r = " dos";
             break;
             
         case "3":
             r = " tres";
             break;
             
         case "4":
             r = " cuatro";
             break;

         case "5":
             r = " cinco";
             break;

         case "6":
             r = " seis";
             break;

         case "7":
             r = " siete";
             break;

         case "8":
             r = " ocho";
             break;

         case "9":
             r = " nueve";
             break;

             
        default:
            r = "";
            break;
     }
        
      return r;
    }

//M�todo para determinar Decenas
    public static String Decenas(String Num) {
        String r="";
        switch(Num) {
            case "11":
            r = " once";
            break;

            case "12":
            r = " doce";
            break;

            case "13":
            r = " trece";
            break;

            case "14":
            r = " catorce";
            break;

            case "15":
            r = " quince";
            break;

            case "16":
            r = " dieciseis";
            break;

            case "17":
            r = " diecisiete";
            break;

            case "18":
            r = " dieciocho";
            break;

            case "19":
            r = " diecinueve";
            break;

            case "1":
            r = " diez";
            break;

            case "2":
            r = " veinte";
            break;

            //Hijos del 20
            case "21":
            r = " veintiuno";
            break;

            case "22":
            r = " veintidos";
            break;

            case "23":
            r = " veintitres";
            break;

            case "24":
            r = " veinticuatro";
            break;

            case "25":
            r = " veinticinco";
            break;

            case "26":
            r = " veintiseis";
            break;

            case "27":
            r = " veintisiete";
            break;

            case "28":
            r = " veintiocho";
            break;

            case "29":
            r = " veintinueve";
            break;

            case "3":
            r = " treinta";
            break;

            case "4":
            r = " cuarenta";
            break;

            case "5":
            r = " cincuenta";
            break;

            case "6":
            r = " sesenta";
            break;

            case "7":
            r = " setenta";
            break;

            case "8":
            r = " ochenta";
            break;

            case "9":
            r = " noventa";
            break;


            default:
            r = "";
            break;
        }
        return r;
    }

//M�todo para determinar Centenas
    public static String Centenas(String Num) {
        String r="";
         switch(Num) {
             case "1":
                 r = " ciento";
                 break;
                 
             case "2":
                 r = " doscientos";
                 break;
                 
             case "3":
                 r = " trescientos";
                 break;
                 
             case "4":
                 r = " cuatrocientos";
                 break;

             case "5":
                 r = " quinientos";
                 break;

             case "6":
                 r = " seiscientos";
                 break;

             case "7":
                 r = " setecientos";
                 break;

             case "8":
                 r = " ochocientos";
                 break;

             case "9":
                 r = " novecientos";
                 break;

                 
            default:
                r = "";
                break;
         }
        return r;
    }

//M�todo para determinar unidades de mil
    public static String Mil(String Num) {
     String r="";
     switch(Num) {
         case "1":
             r = "Mil";
             break;
             
         case "2":
             r = "Dos mil";
             break;
             
         case "3":
             r = "Tres mil";
             break;
             
         case "4":
             r = "Cuatro mil";
             break;

         case "5":
             r = "Cinco mil";
             break;

         case "6":
             r = "Seis mil";
             break;

         case "7":
             r = "Siete mil";
             break;

         case "8":
             r = "Ocho mil";
             break;

         case "9":
             r = "Nueve mil";
             break;

             
        default:
            r = "";
            break;
     }
        return r;
    }


    
} //Cierre public class MontoEscrito
