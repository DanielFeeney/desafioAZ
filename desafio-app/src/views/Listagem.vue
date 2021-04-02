<template>
  <v-data-table
    :headers="headers"
    :items="utensilios"
    sort-by="descricao"
    class="elevation-1"
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
          v-model="dialog"
          max-width="500px"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              color="primary"
              dark
              class="mb-2"
              v-bind="attrs"
              v-on="on"
              to="/Administrador"
            >
              Novo
            </v-btn>
          </template>          
        </v-dialog>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="headline">Tem certeza que deseja deletar esse item?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
              <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>

      <template v-slot:item.acoes="{ item }">
        
        <v-icon
          large
          class="mr-2"
          @click="editItem(item)"
        >
          mdi-pencil
        </v-icon>
        
        <v-icon
          large
          class="mr-2"
          @click="giftItem(item)"
        >
          mdi-gift
        </v-icon>
        <v-icon
          large
          @click="deleteItem(item)"
        >
          mdi-delete
        </v-icon>
      </template>

      
    <template v-slot:no-data>
       Nenhum dado encotrado
    </template>
  </v-data-table>
</template>


<script>
  export default {
    data: () => ({
      dialog: false,
      dialogDelete: false,
      headers: [
        {
          text: 'Descrição',
          align: 'start',
          value: 'descricao',
        },
        { text: 'Data Doação', value: 'dataDoacao' },
        { text: 'Doador', value: 'doador' },
        { text: 'Ações', value: 'acoes', sortable: false },
      ],
      utensilios: [
        {
        id: 1,
        descricao: 'AAAAAAA',
        dataDoacao: 'BBBBBBB',
        doador: 'CCCCCCCC',
      },],
      editedIndex: -1,
      utensilioItem: {
        id: null,
        descricao: '',
        disponivel: 0,
        dataDoacao: 0,
        doador: 0,
      },
      defaultItem: {
        id: null,
        descricao: '',
        disponivel: 0,
        dataDoacao: 0,
        doador: 0,
      },
    }),

    computed: {
      
    },

    watch: {
      dialog (val) {
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
        
      },

      editItem (item) {
        console.log(item)
      },

      deleteItem (item) {
        this.editedIndex = this.utensilios.indexOf(item)
        this.utensilioItem = Object.assign({}, item)
        this.dialogDelete = true
      },

      deleteItemConfirm () {
        this.utensilios.splice(this.editedIndex, 1)
        this.closeDelete()
      },

      closeDelete () {
        this.dialogDelete = false
        this.$nextTick(() => {
          this.utensilioItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },

      save () {
        if (this.editedIndex > -1) {
          Object.assign(this.utensilios[this.editedIndex], this.utensilioItem)
        } else {
          this.utensilios.push(this.utensilioItem)
        }
        this.close()
      },
    },
  }
</script>