const base = {
    get() {
                return {
            url : "http://localhost:8080/diancaixitong/",
            name: "diancaixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/diancaixitong/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "订餐系统"
        } 
    }
}
export default base
