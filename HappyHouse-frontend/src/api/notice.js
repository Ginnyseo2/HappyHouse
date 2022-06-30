import { apiInstance } from "./index.js";

const api = apiInstance();

function listArticle(param, success, fail) {
  api.get(`/notice/list`, { params: param }).then(success).catch(fail);
}
function totalArticle(param, success, fail) {
  api.get(`/notice/total`, { params: param }).then(success).catch(fail);
}
function listFile(param, success, fail) {
  api.get(`/notice/listfile`, { params: param }).then(success).catch(fail);
}

function writeArticle(formData, success, fail) {
  api.post(`/notice/register`, formData).then(success).catch(fail);
}

function getArticle(articleno, success, fail) {
  api.get(`/notice/${articleno}`).then(success).catch(fail);
}

function getFile(articleno, success, fail) {
  api.get(`/notice/file/${articleno}`).then(success).catch(fail);
}

function modifyArticle(formData, success, fail) {
  api.put(`/notice`, formData).then(success).catch(fail);
}

function modifyFile(article, success, fail) {
  api.put(`/notice/file`, JSON.stringify(article)).then(success).catch(fail);
}

function deleteArticle(articleno, success, fail) {
  api.delete(`/notice//${articleno}`).then(success).catch(fail);
}

export {
  listArticle,
  writeArticle,
  getFile,
  listFile,
  getArticle,
  modifyArticle,
  modifyFile,
  deleteArticle,
  totalArticle,
};
