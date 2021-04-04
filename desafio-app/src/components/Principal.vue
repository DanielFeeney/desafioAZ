<template>
  <v-card>
    <v-toolbar
      color="gray"
      dark
      centered
    >

      <v-toolbar-title>Desafio</v-toolbar-title>

      <v-spacer></v-spacer>

      <template v-slot:extension>
        <v-tabs
          align-with-title
        >
          <v-tabs-slider color="yellow"></v-tabs-slider>

          <v-tab
          >
            <router-link to="/">Listagem de Utensílios</router-link>
          </v-tab>
          <v-tab
          >
            <router-link to="/Administrador">Administrador</router-link>
          </v-tab>
        </v-tabs>
      </template>
    </v-toolbar>
  </v-card>
</template>

<script>


  export default {
    data () {
      return {}
    },
  }
</script>