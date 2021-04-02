<template>
<v-container fluid>
    <v-col>
      <v-row>
        <v-card
        id="conteudo"
        max-width="500"
        
        outlined>
        <v-card-title>Cadastrar Usuário</v-card-title>
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
    <v-row>
        <v-card
        id="conteudo"
        max-width="500"
        
        outlined>
        <v-card-title>Cadastrar Utensílio</v-card-title>
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

  <v-row>
    <template>
      <v-btn
        color="primary"
        dark
        class="mb-2"
        v-bind="attrs"
        v-on="on"
        to="/"
      >
        Cancelar
      </v-btn>

      <v-btn
        color="primary"
        dark
        class="mb-2"
        v-bind="attrs"
        v-on="on"
      >
        Salvar
      </v-btn>
    </template>
  </v-row>
  
</v-container>

  
</template>

<style>
  #conteudo{
    padding: 20px;
    margin: 20px;
    width: 50%;
  }
</style>

<script>
  import { validationMixin } from 'vuelidate'
  import { required, maxLength, email } from 'vuelidate/lib/validators'

  export default {
    mixins: [validationMixin],

    validations: {
      nomeCompleto: { required },
      email: { required, email },
      cpf: { required, maxLength: maxLength(11) },
      dataNascimento: {required} ,
      descricao: {required}       
    },

    data: () => ({
      nomeCompleto: '',
      email: '',
      cpf: '',
      dataNascimento: null,
      telefone: '',
      celular:'',
      descricao: '',
    }),

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
        !this.$v.cpf.required && errors.push('Nome Completo é obrigatório.')
        return errors
      },
      descricaoErrors (){
        const errors = []
        if (!this.$v.descricao.$dirty) return errors
        !this.$v.descricao.required && errors.push('Descrição é obrigatório.')
        return errors
      }
    },

    watch: {
      date (val) {
        this.dateFormatted = this.formatDate(this.dataNascimento)
        console.log(val)
      },
    },

    methods: {
      submit () {
        this.$v.$touch()
      },
      clear () {
        this.$v.$reset()
      },
    },
  }
</script>