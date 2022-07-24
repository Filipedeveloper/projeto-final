import { CorrentistaService } from './../../services/correntista.service';
import { CadastroModalComponent } from './../../modal/cadastro-modal/cadastro-modal.component';
import { Component, OnInit } from '@angular/core';
import { MovimentacaoService } from 'src/app/services/movimentacao.service';
import {MatDialog} from '@angular/material/dialog';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-movimentacao-list',
  templateUrl: './movimentacao-list.component.html',
  styleUrls: ['./movimentacao-list.component.scss']
})
export class MovimentacaoListComponent implements OnInit {
   movimentacoes: any;
   correntistas: any;
   correntista: any;
   displayedColumns: string[] = ['conta', 'data', 'descricao', 'valor', 'tipo'];
   dataSource = [];


  constructor(private movimentacaoService: MovimentacaoService, private correntistaService: CorrentistaService, public dialog: MatDialog) { }

  ngOnInit(): void {
this.getCorrentistas();

  }

  openDialog() {
    const dialogRef = this.dialog.open(CadastroModalComponent, {
      width: '50%'
    });

    dialogRef.afterClosed().subscribe(result => {


    });
  }

  getCorrentistas(): void{
    this.correntistaService.list()
    .subscribe(
      data => {
        this.correntistas = data;
        //this.dataSource = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    )
  }

  listmovimentacoes(): void{
    console.log('estou aqui  '+this.correntista)
    this.movimentacaoService.findByIdConta(this.correntista)
    .subscribe(
      data => {
        this.movimentacoes = data;
        this.dataSource = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    )
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter
    //this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
