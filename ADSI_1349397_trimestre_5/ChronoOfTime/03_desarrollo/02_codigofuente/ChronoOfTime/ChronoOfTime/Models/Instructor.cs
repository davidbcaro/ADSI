using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Instructor
    {
        [Key]
        public int IDInstructor { get; set; }

        
        [Display(Name = "Document Number")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public int document_number { get; set; }

        [StringLength(30)]
        [Display(Name = "Name")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string name { get; set; }

        [StringLength(30)]
        [Display(Name = "Second Name")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string second_name { get; set; }

        [StringLength(30)]
        [Display(Name = "Last Name")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string last_name { get; set; }

        [StringLength(30)]
        [Display(Name = "Second Last Name")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string second_last_name { get; set; }

        [Display(Name = "State")]
        public bool state { get; set; }

        [DataType(DataType.ImageUrl)]
        public string Photo { get; set; }
        [NotMapped]
        public HttpPostedFileBase PhotoFile { get; set; }

        public int IDLinkUp { get; set; }
        [ForeignKey("IDLinkUp")]
        public LinkUp linkup { get; set; }

        public int IDDocument { get; set; }
        [ForeignKey("IDDocument")]
        public Document document { get; set; }

        public int IDDisponibility { get; set; }
        [ForeignKey("IDDisponibility")]
        public Disponibility disponibility { get; set; }

        


    }
}