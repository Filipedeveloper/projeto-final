import { MovimentacaoService } from './../../services/movimentacao.service';
import { CorrentistaService } from './../../services/correntista.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}


@Component({
  selector: 'app-cadastro-modal',
  templateUrl: './cadastro-modal.component.html',
  styleUrls: ['./cadastro-modal.component.scss']
})
export class CadastroModalComponent implements OnInit {
  correntistas: any;
  correntista: any;
  movimentacoes:any;
  valor: any;
  descricao: any;
  tipo: any;
  idConta: any;


  constructor(private correntistaService: CorrentistaService, private movimentacaoService: MovimentacaoService) { }

  ngOnInit(): void {
    this.getCorrentistas();
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

  save():void {
    console.log('ESTOU AQUI');
    console.log(this.correntista);
    const movimentacao = {
      valor:this.valor,
      descricao:this.descricao,
      tipo:this.tipo,
      idConta:this.correntista,

    };
    console.log(movimentacao);
    this.movimentacaoService.create(movimentacao)
    .subscribe(
      response=>{
        console.log(response);
      },
      error=>{
        console.log('error');
      }
    )
  }

  listMovimentacoes(): void {
    this.movimentacaoService.findByIdConta(this.correntista.id)
      .subscribe(
        data => {
          this.movimentacoes = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}

