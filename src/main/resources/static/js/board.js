const modal = document.getElementById('modal');

const addReportModal = (id) => {
    modal.dataset.formType = 'add';
    modal.dataset.boardId = id;
    modal.style.display = 'block';
};

const hideAddModal = () => {
    modal.style.display = 'none';
    const elements = modal.getElementsByTagName('input');
    for (const element of elements) {
        element.value = '';
    }
}

const form = document.getElementById('form');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    let report = {};
    for (const entry of formData.entries()) {
        const [key, value] = entry;
        report[key] = value;
    }

    if (modal.dataset.formType === 'add') {
        report['id'] = modal.dataset.boardId
        createReport(report);
    }
});

const createReport = (product) => {
    axios.request({
        method: 'post',
        url: '/api/v1/report' ,
        data: {
            boardId: product.id,
            reportContent: product.content,
        }
    }).then((response) => {
        console.log(response);
        window.location.reload();
    }).catch((error) => {
        console.error(error);
    });
};

const deleteBoard = (id) => {
    axios.request({
        method: 'delete',
        url: '/api/v1/board/' + id,
    }).then((response) => {
        console.log(response);
        window.location.reload();
    }).catch((error) => {
        console.error(error);
    });
};

const updateVisible = (id) => {
    axios.request({
        method: 'put',
        url: '/api/v1/board/' + id,
    }).then((response) => {
        console.log(response);
        window.location.reload();
    }).catch((error) => {
        console.error(error);
    });
};
