import { HttpEventType, HttpResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { Observable } from "rxjs";
import { PlayerService } from "src/app/services/player.service";

@Component({
  selector: "app-player-form",
  templateUrl: "./player-form.component.html",
  styleUrls: ["./player-form.component.css"],
})
export class PlayerFormComponent implements OnInit {
  playerForm: FormGroup;
  player: any = {};

  selectedFiles: FileList;
  progressInfos = [];
  message = "";
  fileInfos: Observable<any>;

  constructor(private playerService: PlayerService) {}

  ngOnInit() {}

  addOrEditPlayer() {
    console.log("Here payer object", this.player);
    this.playerService.addPlayer(this.player, 1).subscribe((data) => {
      console.log("Here reponse from BE after save", data);
    });
  }

  upload(idx, file) {
    this.progressInfos[idx] = { value: 0, fileName: file.name };
    this.playerService.upload(file).subscribe(
      (event) => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progressInfos[idx].value = Math.round(
            (100 * event.loaded) / event.total
          );
        } else if (event instanceof HttpResponse) {
          this.fileInfos = this.playerService.getFiles();
        }
      },
      (err) => {
        this.progressInfos[idx].value = 0;
        this.message = "Could not upload the file:" + file.name;
      }
    );
  }

  uploadFiles() {
    this.message = '';
    for (let i = 0; i < this.selectedFiles.length; i++) {
      this.upload(i, this.selectedFiles[i]);
    }
  }

  selectFiles(event) {
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }
}
