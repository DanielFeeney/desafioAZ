<template>
  <v-data-table
    :headers="headers"
    :items="utensilios"
    sort-by="descricao"
    class="elevation-1"
    data-app
  >
      <template v-slot:top>
      <v-toolbar
        flat
        
      >
        <v-toolbar-title>Utensílios</v-toolbar-title>
        <v-divider
          class="mx-4"
          inset
          vertical
        ></v-divider>
        <v-spacer></v-spacer>
        <v-dialog
          max-width="500px"
          
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn

              color="green"
              depressed
              v-bind="attrs"
              v-on="on"
              to="/Administrador"
            >
              <span style="color: #fff;">Novo</span>
            </v-btn>
          </template>          
        </v-dialog>
        
          <v-dialog v-model="dialogDelete" max-width="500px" max-height="300px">
          <v-card>
            <v-card-title>Tem certeza que deseja deletar esse item?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
              <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
        
        <v-dialog v-model="dialogGift" max-width="500px" max-height="300px">
          <v-card>
            <v-card-title>Deseja doar esse item?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeGift">Cancel</v-btn>
              <v-btn color="blue darken-1" text @click="giftItemConfirm">OK</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>

      <template v-slot:item.actions="{ item }">

        <v-btn
          color="lime"
          class="ma-2 white--text"
          @click="editItem(item)"
          :to="{ name:'Editar', params: { id: item.id } }"
        >
        Editar
          <v-icon
            right
            dark
            
          >
             mdi-pencil
          </v-icon>
        </v-btn>

        <v-btn
          color="deep-purple"
          class="ma-2 white--text"
          @click="giftItem(item)"
        >
        Doar
          <v-icon
            right
            dark
          >
             mdi-gift
          </v-icon>
        </v-btn>

        <v-btn
          color="primary"
          class="ma-2 white--text"
          @click="deleteItem(item)">
          Deletar
          <v-icon
            right
            dark            
          >
            mdi-delete
          </v-icon>
        </v-btn>

      
      </template>

      
    <template v-slot:no-data>
       Nenhum dado encotrado
    </template>
  </v-data-table>
</template>


<script>
import UtensilioService from '../service/Utensilios';

  export default {
    data: () => ({
      dialogGift: false,
      dialogDelete: false,
      headers: [
        {
          text: 'Descrição',
          align: 'start',
          value: 'descricao',
        },
        { text: 'Data Doação', value: 'dataDoacao' },
        { text: 'Doador', value: 'doador' },
        { text: 'Ações', value: 'actions', sortable: false },
      ],
      utensilios: [],
      editedIndex: -1,
      utensilioItem: {
        id: null,
        descricao: '',
        dataDoacao: '',
        doador: '',
      },
      defaultItem: {
        id: null,
        descricao: '',
        dataDoacao: '',
        doador: '',
      },
    }),

    computed: {
      
    },

    watch: {
      dialogGift (val) {
        val || this.close()
      },
      dialogDelete (val) {
        val || this.closeDelete()
      },
    },

    created () {
      this.initialize()
    },

    methods: {
      initialize () {
        this.service = new UtensilioService('utensilio');

        this.service.listar()
        .then(
            utensilios => {this.utensilios = utensilios.data;},
            err =>  console.log(err)
        );
      },

      deleteItem (item) {
        console.log(item)
        this.editedIndex = this.utensilios.indexOf(item)
        this.utensilioItem = Object.assign({}, item)
        this.dialogDelete = true
      },

      deleteItemConfirm () {   
        console.log(this.utensilioItem); 
        this.service.deletar(this.utensilioItem.id)
            .then(() => {
                this.utensilios.splice(this.editedIndex, 1)
            }, err => {this.msgInvalida = true; console.log(err)} );
        this.closeDelete()
      },
      
      closeDelete () {
        this.dialogDelete = false
        this.$nextTick(() => {
          this.utensilioItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },







      giftItem (item) {
        this.editedIndex = this.utensilios.indexOf(item)
        this.utensilioItem = Object.assign({}, item)
        this.dialogGift = true
      },

      giftItemConfirm () {        
        this.service.doar(this.utensilioItem.id)
            .then(() => {
                this.utensilios.splice(this.editedIndex, 1)
            }, err => {this.msgInvalida = true; console.log(err)} );
        this.closeGift()
      },

      closeGift () {
        this.dialogGift = false
        this.$nextTick(() => {
          this.utensilioItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },
    },
  }
</script>