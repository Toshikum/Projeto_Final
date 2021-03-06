/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Classes.Pessoa;
import DAO.DAO;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author toshi
 */
public class ModeloTabela extends AbstractTableModel {
    private List <Pessoa> pessoas;
    private String [] colunas = {"ID","Nome", "Idade", "Profissional da Saúde"};
    public ModeloTabela() throws Exception{
    DAO dao = new DAO ();
    this.pessoas = dao.obterPessoa();
    Collections.sort(pessoas, Collections.reverseOrder());
    }
    @Override
    public int getRowCount() {
        return pessoas.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex){
        case 0:
            return this.pessoas.get(rowIndex).getId();
        case 1:
            return this.pessoas.get(rowIndex).getNome();
        case 2:
            return this.pessoas.get(rowIndex).getIdade();
        case 3:
            return this.pessoas.get(rowIndex).isSaude();
        default:
        return null;
        }
    }
    @Override
    public String getColumnName(int column) {
    return this.colunas[column];
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
    
}

