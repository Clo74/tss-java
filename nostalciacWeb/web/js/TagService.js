import AbstractService from './AbstractService.js';
export default class TagService extends AbstractService {
    constructor() {
        super();
        this.url = this.baseUrl + "/tags"
    }

    async all(start,page) {
        const data = await fetch(this.url + `?start=${start}&page=${page}`, {
            method: 'get',
            headers: {
                'Accept': 'application/json'
            }
        })
        .then(response => response.json())
        .catch(res => console.error(res))
        return data;
    }
    
    
}


