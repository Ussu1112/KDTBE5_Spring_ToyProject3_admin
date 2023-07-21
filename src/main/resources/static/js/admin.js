const mainAddress = "http://localhost:8080";

function redirectMain(){
    window.location.href = mainAddress;
}

const form = document.getElementById('form');

const createProduct = (product) => {
    axios.request({
        method: 'post',
        url: '/product',
        data: {
            name: product.name,
            price: product.price,
            imageUrl: product.imageUrl
        }
    }).then((response) => {
        console.log(response);
        window.location.reload();
    }).catch((error) => {
        console.error(error);
    });
};

const updateProduct = (product) => {
    axios.request({
        method: 'put',
        url: '/product/' + product.id,
        data: {
            name: product.name,
            price: product.price,
            imageUrl: product.imageUrl
        }
    }).then((response) => {
        console.log(response);
        window.location.reload();
    }).catch((error) => {
        console.error(error);
    });
};

const addBlackList = (id) => {
    axios.request({
        method: 'post',
        url: '/api/v1/black/' + id,
    }).then((response) => {
        console.log(response);
        window.location.reload();
    }).catch((error) => {
        console.error(error);
    });
};
