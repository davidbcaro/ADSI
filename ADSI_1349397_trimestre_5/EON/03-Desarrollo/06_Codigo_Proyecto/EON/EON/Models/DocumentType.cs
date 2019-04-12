using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class DocumentType
    {
        [Key]
        [Display(Name = "idDocumentType")]
        public int id_Document { get; set; }


      


        [Display(Name = "typeDocument")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(100, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string typeDocument { get; set; }


        [Display(Name = "Status")]
        public bool Status { get; set; }


        public virtual ICollection<Instructor> Instructor { get; set; }
    }


}