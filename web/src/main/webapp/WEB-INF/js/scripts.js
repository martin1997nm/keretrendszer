import serialize from 'form-serialize';

const formData = serialize(formNode, { hash: true });
const apiData = { name: formData.firstName, year: formData.birthYear };
const json = JSON.stringify(apiData);