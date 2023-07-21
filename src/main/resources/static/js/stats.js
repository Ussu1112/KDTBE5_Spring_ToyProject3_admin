let order = "asc"
const updateOrder = (columnName) => {
    axios.request({
        method: 'get',
        url: '/api/v1/stats',
        data: {
            columnName: columnName,
            order : "asc",
        }
    }).then((response) => {
        console.log(response);
        if(order==="asc"){
            order = "desc";
        } else {
            order = "asc";
        }
    }).catch((error) => {
        console.error(error);
    });
};