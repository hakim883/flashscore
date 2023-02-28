import { HttpClient, HttpEvent, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class PlayerService {
  playerURL = "http://localhost:8090/api/players";
  // playerURL = "api/Players";
  constructor(private httpClient: HttpClient) {}

  getAllPlayers() {
    return this.httpClient.get(this.playerURL);
  }

  getPlayerById(id: number) {
    return this.httpClient.get(`${this.playerURL}/${id}`);
  }

  addPlayer(player, teamId) {
    return this.httpClient.post(`${this.playerURL}/${teamId}`, player);
  }

  updatePlayer(player) {
    return this.httpClient.put(this.playerURL, player);
  }

  deletePlayerById(id: number) {
    return this.httpClient.delete(`${this.playerURL}/${id}`);
  }

  // returns httpevent for tracking progress
  // FormData is a data structure that can be used to store key-value pairs
  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    this.resetform(formData);
    formData.append("file", file);
    const req = new HttpRequest("POST", `${this.playerURL}/upload`, formData, {
      reportProgress: true,
      responseType: "json",
    });
    return this.httpClient.request(req);
  }

  getFiles(): Observable<any> {
    return this.httpClient.get(`${this.playerURL}/files`);
  }

  resetform(x) {
    x = new FormData();
  }
}
