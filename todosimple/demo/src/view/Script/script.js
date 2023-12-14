document.addEventListener("DOMContentLoaded", function () {
    // URL da sua API Spring Boot
    const apiUrl = "http://localhost:8080/ingresso/1";
    

    // Realiza a requisição usando o Fetch API
    fetch(apiUrl)
        .then(response => {
            // Verifica se a resposta foi bem-sucedida (código 2xx)
            if (!response.ok) {
                throw new Error(`Erro na requisição: ${response.status}`);
            }
            // Converte a resposta para JSON
            return response.json();
        })
        .then(userData => {
            // Manipula os dados do usuário obtidos
            console.log("Dados do usuário:", userData);
            // Aqui você pode usar os dados como desejar
        })
        .catch(error => {
            console.error("Erro na requisição:", error);
        });
});



/*const inome = document.getElementById("name");
const iemail = document.getElementById("email");
const iCPF = document.getElementById("CPF");
const idatanasc = document.getElementById("datanasc");
const ipix = document.getElementById("pix");
const ipassword = document.getElementById("password");


function cadastrar(event) {
    event.preventDefault(); // Prevent the default behavior of the anchor tag
    
    fetch("http://localhost:8080/user"), 
    {
        headers: {
            "Accept": "aplication/json",
            "Content=Type": "aplication/json"
        },
        method: "POST",
        body: JSON.stringify({

                username: inome.value,
                password: ipassword.value,
                cpf: iCPF.value,
                email: iemail.value,
                chavePix: ipix.value,
                rg: "111111111",
              
        })
    } 
    .then(function (res){console.log(res)})
    .catch(function (res) {console.log(res)})
}

document.addEventListener('DOMContentLoaded', function () {
    // Get the button element
    const cadastrarButton = document.querySelector('.continue-button button');
    
    // Attach the event listener to the button
    cadastrarButton.addEventListener('click', cadastrar);
});


/*document.addEventListener('DOMContentLoaded', function () {
    getUrl(url);
}); 


async function getUrl(url){
    const response = await fetch(url, {method: "GET"});

    var data = await response.json();
    console.log(data)
} */