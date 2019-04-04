set serveroutput ON



declare

    v_name VARCHAR(55);
    v_count INT;
begin
    
    v_name := 'Marco Antonio';
    
    v_cout := 0;
    
    dbms_output.DBMS_OUTPUT.PUT_LINE(INSTR(v_name, ' ', ));
    
end;




