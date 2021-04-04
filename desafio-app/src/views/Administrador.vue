<template>

<v-container fluid data-app>
  
      <v-alert
      dense
      type="error"
      v-model="alertInvalid"
      border="left"
      close-text="Fechar"
      dismissible
      transition="scale-transition"
    >
      Cheque as informações novamente.</v-alert>
    <v-alert
      dense
      type="error"
      v-model="alertError"
      border="left"
      close-text="Fechar"
      dismissible
      transition="scale-transition"
    >
      Erro ao salvar.</v-alert>
    <v-alert
      dense
      type="success"
      v-model="alertSuccess"
      border="left"
      close-text="Fechar"
      dismissible
      transition="scale-transition"
    >
      Salvo com sucesso.</v-alert>
    <v-col>
      <v-row dense>
        <v-card
        id="conteudo"
        max-width="500"        
        elevation="2"
        outlined>
        <v-card-title>{{cadastro}} Usuário</v-card-title>
          <form>
            <v-text-field
              v-model="nomeCompleto"
              :error-messages="nameErrors"
              label="Nome Completo"
              required
              @input="$v.nomeCompleto.$touch()"
              @blur="$v.nomeCompleto.$touch()"
            ></v-text-field>

            <v-text-field
              v-model="email"
              :error-messages="emailErrors"
              label="E-mail"
              required
              @input="$v.email.$touch()"
              @blur="$v.email.$touch()"
            ></v-text-field>

            <v-menu
              ref="menu"
              v-model="menu"
              :close-on-content-click="false"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="dataNascimento"
                  label="Data Nascimento"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                ref="picker"
                v-model="dataNascimento"
                :error-messages="dataNascimentoErrors"
                @input="$v.dataNascimento.$touch()"
                @blur="$v.dataNascimento.$touch()"
                required
                :max="new Date().toISOString().substr(0, 10)"
                @change="save"
              ></v-date-picker>
            </v-menu>

            <v-text-field
              v-model="cpf"
              :error-messages="cpfErrors"
              :counter="11"
              label="CPF"
              required
              @input="$v.cpf.$touch()"
              @blur="$v.cpf.$touch()"
            ></v-text-field>

            <v-text-field
              v-model="telefone"
              label="Telefone Fixo"
            ></v-text-field>

            <v-text-field
              v-model="celular"
              label="Celular"
            ></v-text-field>
        </form>
      </v-card>
    </v-row>
    <v-row dense>
        <v-card
        id="conteudo"
        max-width="500"        
        elevation="2"
        outlined>
        <v-card-title>{{cadastro}} Utensílio</v-card-title>
          <form>
            <v-text-field
              v-model="descricao"
              :error-messages="descricaoErrors"
              label="Descrição"
              required
              @input="$v.descricao.$touch()"
              @blur="$v.descricao.$touch()"
            ></v-text-field>
        </form>
      </v-card>
    </v-row>
  </v-col>
  <v-toolbar
    >
    <template>
      <v-btn
        color="primary"
        class="mb-1"
        to="/"
      >
        Voltar
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        color="green"
        @click="submit"
      >
        <span style="color: #fff;">Salvar</span>
      </v-btn>
    </template>
    </v-toolbar>
  
</v-container>

  
</template>

<style>
  #conteudo{
    padding: 20px;
    margin: auto;
    margin-bottom: 10px;
    width: 100%;
  }
</style>

<script>
  import { validationMixin } from 'vuelidate'
  import { required, maxLength, email } from 'vuelidate/lib/validators'

  import UtensilioService from '../service/Utensilios'

  export default {
    mixins: [validationMixin],

    validations: {
      nomeCompleto: { required },
      email: { required, email },
      cpf: { required, maxLength: maxLength(11) },
      dataNascimento: {required} ,
      descricao: {required}       
    },

    data() {
      
      return{
        alertInvalid: false,
        alertError: false,
        alertSuccess: false,
        cadastro: 'Cadastro',
        nomeCompleto: '',
        email: '',
        cpf: '',
        dataNascimento: null,
        telefone: '',
        celular:'',
        descricao: '',
        id: this.$route.params.id,
        menu: false,
      }
      
    },

    computed: {
      nameErrors () {
        const errors = []
        if (!this.$v.nomeCompleto.$dirty) return errors
        !this.$v.nomeCompleto.required && errors.push('Nome Completo é obrigatório.')
        return errors
      },
      emailErrors () {
        const errors = []
        if (!this.$v.email.$dirty) return errors
        !this.$v.email.email && errors.push('E-mail deve ser válido')
        !this.$v.email.required && errors.push('E-mail é obrigatório')
        return errors
      },
      cpfErrors () {
        const errors = []
        if (!this.$v.cpf.$dirty) return errors
        !this.$v.cpf.maxLength && errors.push('CPF deve ser válido')
        !this.$v.cpf.required && errors.push('CPF é obrigatório.')
        return errors
      },
      descricaoErrors (){
        const errors = []
        if (!this.$v.descricao.$dirty) return errors
        !this.$v.descricao.required && errors.push('Descrição é obrigatório.')
        return errors
      },
      dataNascimentoErrors () {
        const errors = []
        if (!this.$v.dataNascimento.$dirty) return errors
        !this.$v.dataNascimento.required && errors.push('Data de Nascimento é obrigatório.')
        return errors
      }
    },

    watch: {
      menu (val) {
        val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
      },
    },

    methods: {
      submit () {
        this.$v.$touch()
        console.log(this.$v)
        if(!this.$v.$invalid){
          this.service.salvar({
          id: this.id,
          nomeCompleto: this.nomeCompleto,
          email: this.email,
          cpf: this.cpf,
          dataNascimento: this.dataNascimento,
          telefone: this.telefone,
          celular: this.celular,
          descricao: this.descricao,
          }).then(() => {
                this.alertaSucesso()
              })
            .catch(() => {
                this.alertaErro()
            })
        }
        else{
          this.alertInvalid = true;
        }
      },

      save (date) {
        this.$refs.menu.save(date)
      },

      alertaErro(){
        this.alertError = true;
      },

      alertaSucesso(){
        this.alertSuccess = true;
      },
    },

    

    created(){
      this.service = new UtensilioService('utensilio');

      if(this.id){
        this.cadastro = "Editar"
        this.service.buscar(this.id).then(utensilio => {
          this.nomeCompleto = utensilio.data.nomeCompleto;
          this.email = utensilio.data.email;
          this.cpf = utensilio.data.cpf;
          this.dataNascimento = utensilio.data.dataNascimento;
          this.telefone = utensilio.data.telefone;
          this.celular = utensilio.data.celular;
          this.descricao = utensilio.data.descricao;
        });
      }
    }
  }
</script>