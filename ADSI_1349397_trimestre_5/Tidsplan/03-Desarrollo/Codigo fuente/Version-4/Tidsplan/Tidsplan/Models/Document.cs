using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Document
    {
        [Key]
        public int documentID { get; set; }

      
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Tipo de documento")]
        [StringLength(20, ErrorMessage = "Debe tener mínimo dos caracteres, máximo veinte caracteres.", MinimumLength = 2)]
        [Index("Document_idDocument_Index", IsUnique = true)]
        public String idDocument { get; set; }

        
        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Descripción")]
        [StringLength(50, ErrorMessage = "Debe tener mínimo dos caracteres, máximo cincuenta caracteres.", MinimumLength = 2)]
        [Index("Document_typeDocument_Index", IsUnique = true)]
        public String typeDocument { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Tipo de documento")]
        public String toUpper
        {
            get
            {
                if (idDocument != null)
                {
                    idDocument = idDocument.ToUpper();
                }
                else
                {
                    idDocument = "Es requerido.";
                }
                return idDocument;
            }
            set
            {
                if (idDocument != null)
                {
                    idDocument = idDocument.ToUpper();
                }
                else
                {
                    idDocument = "Es requerido.";
                }
                idDocument.ToUpper();
            }
        }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Descripción")]
        public String toUpperTwo
        {
            get
            {
                if (typeDocument != null)
                {
                    typeDocument = typeDocument.ToUpper();
                }
                else
                {
                    typeDocument = "Es requerido.";
                }
                return typeDocument;
            }
            set
            {
                if (typeDocument != null)
                {      
                    typeDocument = typeDocument.ToUpper();
                }
                else
                {
                    typeDocument = "Es requerido.";
                }
                typeDocument.ToUpper();
            }
        }

        public virtual ICollection<Instructor> Instructor { get; set; }

 
    }
}