<template>
  <div id="app"> 
    <v-main>
      <v-toolbar
      color="gray"
      dark
      centered
    >

      <v-toolbar-title>Desafio</v-toolbar-title>

      <v-spacer></v-spacer>

    </v-toolbar>
    </v-main>   
    <router-view/>
    
  </div>
</template>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

</style>

<script>

</script>