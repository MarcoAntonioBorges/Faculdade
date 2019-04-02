
-- Exercicio 1

declare
    qt_espaco integer(2);
    nome varchar2(200) := 'fernando dos santos ribeiro ';
begin 
   nome := trim(trailing ' ' from nome);
   qt_espaco :=(length(nome) - length(replace(nome, ' ')))+1;
   dbms_output.put_line ('o nome tem ' || qt_espaco || ' partes');
end;


-- Exercicio 2

 declare
  n number :=0;
begin
  while (n <= 20) loop
    if mod(n,2)=0 then
      dbms_output.put_line (n);
    end if;
    n:=n+1;
  end loop;
end;


-- exercicio 3

DECLARE
  v_nome varchar2(100);
  v_tipo_obj varchar2(100);
  v_data  date;
BEGIN

    SELECT OBJECT_NAME, OBJECT_TYPE, CREATED
    INTO v_nome, v_tipo_obj, v_data
    FROM (SELECT OBJECT_NAME, OBJECT_TYPE, CREATED
    FROM USER_OBJECTS ORDER BY CREATED)
    WHERE ROWNUM = 1;
    dbms_output.put_line ('Objeto ' || v_nome || ' do tipo ' || v_tipo_obj || ' criado em ' || to_char(v_data,'dd/mm/yyyy hh:mm:ss'));
END;

-- exercicio 4

alter session set nls_language='brazilian portuguese' 

declare 
    v_date date:=CURRENT_DATE;
    v_result varchar2(100);

begin
  
  v_result:=TO_CHAR (TO_DATE (v_date), 'DAY');
  
 dbms_output.put_line(v_result);

end;


-- exercicio 5


-- exercicio 6
set serveroutput on;

declare
 nome varchar2(200) := 'fernando dos santos ribeiro';
 qt_caracteres integer(10);
 qt_espaco integer(10);
 qt_palavras integer(10);
 primeira_palavra varchar2(200);
 ultima_palavra varchar2(200);
 begin
   nome := trim(trailing ' ' from nome);
   
  
   
   if trim(nome)is null then
        dbms_output.put_line('nome invalido');
   else 
   qt_caracteres := length(nome);
   qt_espaco := (length(nome) - length(replace(nome,' ')));
   qt_palavras := (length(nome) - length(replace(nome,' '))+1);
   primeira_palavra := substr(nome,1,instr(nome,' ',1));
   ultima_palavra := substr(nome,instr(nome,' ',instr(nome,' ',-1)),length(nome));
   
   
     --select substr('fernando dos santos ribeiro',instr('fernando dos santos ribeiro',' ',20),length('fernando dos santos ribeiro')) from dual;
   
   -- select instr('fernando dos santos ribeiro',' ',-1)  from dual;
   
   -- select substr('fernando ribeiro',instr('fernando ribeiro',' '),length('fernando ribeiro')) from dual;
   
   
   dbms_output.put_line('Qt_caracteres : '||qt_caracteres);
   dbms_output.put_line('Qt_espaco : '||qt_espaco);
   dbms_output.put_line('Qt_palavras : '||qt_palavras);
   dbms_output.put_line('primeira_palavras : '||primeira_palavra);
   dbms_output.put_line('ultima_palavras : '|| ultima_palavra);
   end if;
  
   
 end;
 
 
 -- exercico 7
 declare 
 nome varchar2(200):= 'fernando dos santos ribeiro';
 n varchar2(200);
 qt_espaco integer(10);
 posicao integer(10);
 begin
    nome := trim(trailing ' ' from nome);
    qt_espaco := (length(nome)- length(replace(nome,' ')))+1;
    for i in 1 .. qt_espaco loop
    
    posicao := instr(nome,' ',1,i);
    
    n := null;
    n := substr(nome,1,posicao);
   -- select substr('fernando ribeiro',1,instr('fernando ribeiro',' ',9)) from dual;
          -- select  Upper(SUBSTR('fernando', 1, 1)) from dual;
       -- select instr('fernando dos santos ribeiro',' ',1,3) from dual;
   DBMS_OUTPUT.put_line(n);
        
    end loop;
    --DBMS_OUTPUT.put_line(nome);
 end;


-- exercicio  8

DECLARE
    dt_inicial date := to_date('&DataInicial','dd/mm/yyyy');
    dt_final date := to_date('&DataFinal','dd/mm/yyyy');
    contador number;
BEGIN

    SELECT COUNT (*) INTO v_contador
    FROM USER_TABLES
    WHERE last_analyzed BETWEEN v_data_inicial AND v_data_final;

    dbms_output.put_line('Quantidade de tabelas criadas: ' || v_contador);
END;


-- exercicio 9

DECLARE
v_nome varchar2(100):='&Nome';
v_contador number;
BEGIN
    SELECT COUNT(UI.INDEX_NAME)
    INTO v_contador
    FROM USER_TABLES UT
        JOIN USER_INDEXES UI
        ON UT.TABLE_NAME = UI.TABLE_NAME
    WHERE UT.TABLE_NAME = v_nome;
    dbms_output.put_line('Quantidade de indice relacionados a  tabela informada : ' || v_contador);
END;