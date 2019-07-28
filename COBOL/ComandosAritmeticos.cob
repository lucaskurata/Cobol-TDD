      *================================================================*
       IDENTIFICATION                                  DIVISION.
      *================================================================*
       PROGRAM-ID. "Comandos aritmeticos".
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
       77  WRK-CONTADOR                    PIC 9(3) VALUE ZEROS.
       77  WRK-REPLACE                     PIC 9(2) VALUE 10.
       77  WRK-COMPUTE                     PIC 9(3) VALUE 100.
       77  WRK-RECEBE_COMPUTE              PIC 9(3) VALUE ZEROS.
       

      *-----------------------------------------------------------------
      *=================================================================
       PROCEDURE                                       DIVISION.
      *=================================================================
           ADD 10 TO WRK-CONTADOR.
           ADD 90 TO WRK-CONTADOR.
           DISPLAY WRK-CONTADOR.

           ADD 900 TO WRK-CONTADOR
           ON SIZE ERROR
               DISPLAY 'VALOR DE 3 BYTES EXCEDIDO!'
           END-ADD.

           ADD 50 GIVING WRK-REPLACE
           DISPLAY 'GIVING ' WRK-REPLACE.

           COMPUTE WRK-COMPUTE EQUAL WRK-COMPUTE * 2
           DISPLAY WRK-COMPUTE.

           COMPUTE WRK-RECEBE_COMPUTE EQUAL WRK-COMPUTE
           DISPLAY WRK-RECEBE_COMPUTE.

           COMPUTE WRK-COMPUTE EQUAL (WRK-COMPUTE  + 2)*10
           ON SIZE ERROR
               DISPLAY 'ERRO NA FORMULA, BYTES EXCEDIDO'
           END-COMPUTE.

           STOP RUN.
