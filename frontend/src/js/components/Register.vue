<template>
    <form @submit.prevent="submitHandler">
        <div class="form-container">
        <div class="title-aut">Форма регистрации:</div>
        <div class="form-group">
            <label for="phone">Телефонный номер:</label>
            <input class="form-control form-control-sm" 
            id="phone" 
            type="text"
            v-model.trim="phone"
         
            placeholder="+7 999 999 99 99" />
            <small class="helper">
                ПИШИ СВОЙ ТЕЛЕФОН
            </small>
            
            </div>
        <div class="form-group">
            <label for="email">Email-адрес:</label>
            <input class="form-control form-control-sm" 
            id="email" 
            type="text"
            v-model.trim="email"
            :class="{invalid: ($v.email.$dirty && !$v.email.required) || ($v.email.$dirty && !$v.email.email)}" 
            placeholder="example@mail.ru" />
            <small class="helper" v-if="$v.email.$dirty && !$v.email.required">
                Поле Email не должно быть пустым
            </small>
            <small class="helper" v-else-if="$v.email.$dirty && !$v.email.email">
                Введите корректный Email
            </small>
            </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input class="form-control form-control-sm" 
            id="password" 
            type="password" 
            v-model.trim="password"
            :class="{invalid: ($v.password.$dirty && !$v.password.required) || ($v.password.$dirty && !$v.password.minLengthPwd)}" 
            />
            
            <small class="form-text text-muted" id="passHelpler">Никому не сообщайте свой пароль!</small>
            <small class="helper" v-if="$v.password.$dirty && !$v.password.required">
                Введите пароль
            </small>
            <small class="helper" v-else-if="$v.password.$dirty && !$v.password.minLengthPwd">
                Пароль должен быть {{$v.password.$params.minLengthPwd.min}} символов. Осталось {{$v.password.$params.minLengthPwd.min - password.length }}
            </small>
            </div>
        
        <div class="form-group form-check">
        </div>
            <button class="btn btn-success pull-right" type=submit>Отправить</button>
        </div>
    </form>
</template>

<script>

import {email, required, minLength} from 'vuelidate/lib/validators'
export default {
    name: 'register',
    data: () => ({
        phone: '',
        email: '',
        password: ''
    }),
    validations: {
        phone: {required},
        email: {email, required},
        password: {required, minLengthPwd: minLength(6)}
    },
    methods: {
        submitHandler(){
            if (this.$v.$invalid) {
                this.$v.$touch()
                return
            }
            const formData = {
                phoneNumber: this.phone,
                email: this.email,
                password: this.password
            }
            console.log(formData)

        }
    }
    
}
</script>