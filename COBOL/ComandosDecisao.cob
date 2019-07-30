      *================================================================*
       IDENTIFICATION                                  DIVISION.
      *================================================================*
       PROGRAM-ID. "Comandos decisao".
       AUTHOR. "LUCAS KURATA".
      *================================================================*
       ENVIRONMENT                                     DIVISION.
      *=================================================================
      *-----------------------------------------------------------------
       CONFIGURATION                          SECTION.
      *-----------------------------------------------------------------

       SPECIAL-NAMES.


      *-----------------------------------------------------------------
       INPUT-OUTPUT                           SECTION.
      *=================================================================

      *=================================================================
      *-----------------------------------------------------------------
       FILE-CONTROL.
      *=================================================================
       DATA                                            DIVISION.
      *=================================================================
      *-----------------------------------------------------------------
       FILE                                   SECTION.
      *-----------------------------------------------------------------
      *-----------------------------------------------------------------
       WORKING-STORAGE                     SECTION.
       77  WRK-NUMERO                      PIC 9(5) VALUE 2468.

       77  WRK-NUMERO2                     PIC 9(5) VALUE 8642.

       77  WRK-TELEFONE                    PIC A(5) VALUE 'ABCD'.

       77  WRK-NEGATIVO                    PIC S9(3) VALUE -100.

      *-----------------------------------------------------------------
      *=================================================================
       PROCEDURE                                       DIVISION.
      *=================================================================

           IF WRK-NUMERO EQUAL WRK-NUMERO2
               DISPLAY 'EH IGUAL'
           ELSE
               DISPLAY 'NAO EH IGUAL'
           END-IF

           IF WRK-NUMERO2 GREATER WRK-NUMERO
               DISPLAY WRK-NUMERO2 ' EH MAIOR'
           IF WRK-NUMERO2 LESS WRK-NUMERO
               DISPLAY WRK-NUMERO 'EH MAIOR'
           END-IF.

           IF WRK-NUMERO IS NUMERIC AND WRK-NUMERO2 IS NUMERIC
               DISPLAY WRK-NUMERO ' E ' WRK-NUMERO2 ' SAO NUMERICOS'
           END-IF.

           IF WRK-NEGATIVO IS POSITIVE
               DISPLAY WRK-NEGATIVO ' EH POSITIVO'
           ELSE
               DISPLAY WRK-NEGATIVO ' EH NEGATIVO'
           END-IF.

           STOP-RUN.
