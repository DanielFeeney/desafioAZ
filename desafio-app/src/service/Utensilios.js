const axios = require('axios');

export default class UtensilioService {

    constructor(local) {
        this.local = 'http://localhost:8081/' + local
    }

    salvar(utensilio) {
        if(utensilio.id){
            return axios.put(`${this.local}/${utensilio.id}`, utensilio);
        }else{
            return axios.post(this.local, utensilio);
        }
    }

    listar() {
        return axios.get(this.local)
    }

    deletar(id) {
        return axios.delete(`${this.local}/${id}`);
    }

    buscar(id) {
        return axios.get(`${this.local}/${id}`);
    }

    doar(id){
        return axios.delete(`${this.local}/doar/${id}`);
    }
}